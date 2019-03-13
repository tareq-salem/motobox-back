package com.hoc.motobox.controller;

import com.hoc.motobox.utils.SuperController;
import com.hoc.motobox.utils.SuperRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoc.motobox.entity.Ad;

@RestController
@RequestMapping("/ad")
public class AdController extends SuperController<Ad> {

    @Autowired
    public AdController(SuperRestService<Ad> service) {
        super(service);
    }

}
