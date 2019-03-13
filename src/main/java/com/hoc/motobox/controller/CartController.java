package com.hoc.motobox.controller;

import com.hoc.motobox.entity.Cart;

import com.hoc.motobox.utils.SuperController;
import com.hoc.motobox.utils.SuperRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController extends SuperController<Cart> {

    @Autowired
    public CartController(SuperRestService<Cart> service){
        super(service);
    }

}
