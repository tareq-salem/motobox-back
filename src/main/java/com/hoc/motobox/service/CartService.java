package com.hoc.motobox.service;

import com.hoc.motobox.entity.Cart;
import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.repository.AdRepository;
import com.hoc.motobox.repository.CartRepository;

import com.hoc.motobox.repository.UserRepository;
import com.hoc.motobox.utils.SuperRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService implements SuperRestService<Cart> {

    @Autowired
    private CartRepository cartDao;
    private AdRepository adDao;
    private UserRepository userDao;

    @Override
    public JpaRepository<Cart, Long> getDao(){
        return cartDao;
    }

    public CartService(AdRepository adDao, UserRepository userDao){
        this.adDao = adDao;
        this.userDao = userDao;
    }

    ///cart?item=roue
    // TODO trouver solution pour récupérer l'user connecter => SECURITE SERVICE
    public Cart addNewItem(AdRepository adDao , Long adId){

        Cart cart = new Cart();
        //Ad ad = adDao.findById(adId);
        //cart.setAd(ad);
        return cart;
    }

//    public Cart removeItem(Long ad_id,  Long id){
//       this.cartDao.findById(id);
//        if(cart){
//            cartDao.getAd();
//        }
//    }


}
