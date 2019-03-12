package com.hoc.motobox.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hoc.motobox.repository.UserRepository;

public class UserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

}
