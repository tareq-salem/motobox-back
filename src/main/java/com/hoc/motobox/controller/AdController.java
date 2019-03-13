package com.hoc.motobox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.utils.GenericRestController;
import com.hoc.motobox.utils.RestService;

@RestController
@RequestMapping("/ad")
public class AdController extends GenericRestController<Ad> {

    @Autowired
    public AdController(RestService<Ad> serv) {
        super(serv);
    }

}
