package com.hoc.motobox.service;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.entity.Role;
import com.hoc.motobox.entity.User;
import com.hoc.motobox.repository.RoleRepository;
import com.hoc.motobox.repository.UserRepository;
import com.hoc.motobox.utils.SuperRestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Set;

@Service
public class UserService extends InitialDataLoader implements SuperRestService<User> {

    private static final Logger LOGGER = LogManager.getLogger(User.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleReposytory;

    @Autowired
    AdService adService;

    @Override
    public JpaRepository<User, Long> getDao() {
        return userRepository;
    }

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User save(User user) {
        LOGGER.debug("create user {}", user);

        if (emailExists(user.getEmail())) {
            throw new EntityExistsException("There is an account with that email adress: " + user.getEmail());
        }
        User createUser = new User();

        createUser.setEmail(user.getEmail());
        createUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        createUser.setFirstName(user.getFirstName());
        createUser.setLastName(user.getLastName());
        createUser.setPhone(user.getPhone());
        createUser.setAddress(user.getAddress());

        Role userRole;
        if (user.getRole() != null) {
            userRole = roleReposytory.findByName(user.getRole().getName());
        } else {
            userRole = roleReposytory.findByName("USER");
        }
        createUser.setRole(userRole);

        return userRepository.save(createUser);

    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    public Ad addAdToCart(Long idAd) {

        Ad ad = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            User currentUser = userRepository.findByEmail(currentUserName);
            ad = adService.findById(idAd).orElseGet(null);

            Set<Ad> cart = currentUser.getPanier();
            cart.add(ad);
            currentUser.setPanier(cart);
            userRepository.save(currentUser);

        }

        return ad;
    }

    public User removeAdFromCart(Long idAd) {

        User currentUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            currentUser = userRepository.findByEmail(currentUserName);
            Ad ad = adService.findById(idAd).orElseGet(null);

            Set<Ad> cart = currentUser.getPanier();
            cart.remove(ad);
            currentUser.setPanier(cart);
            userRepository.save(currentUser);

        }

        return currentUser;
    }

    public Set<Ad> getCart() {

        User currentUser = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            currentUser = userRepository.findByEmail(currentUserName);
        }
        return currentUser.getPanier();
    }

    @Override
    public User update(Long id, User userUpdate) {
        User user = userRepository.findById(id).orElseGet(null);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {

            user.setEmail(userUpdate.getEmail());
            user.setPassword(bCryptPasswordEncoder.encode(userUpdate.getPassword()));
            user.setFirstName(userUpdate.getFirstName());
            user.setLastName(userUpdate.getLastName());
            user.setPhone(userUpdate.getPhone());
            user.setAddress(userUpdate.getAddress());

            Role userRole;
            if (userUpdate.getRole() != null) {
                userRole = roleReposytory.findByName(userUpdate.getRole().getName());
            } else {
                userRole = roleReposytory.findByName("USER");
            }
            user.setRole(userRole);
        }

        return userRepository.save(user);
    }

}
