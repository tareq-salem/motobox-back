package com.hoc.motobox.service;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.repository.AdRepository;
import com.hoc.motobox.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdService implements RestService<Ad> {

    @Autowired
    private AdRepository adRepository;

    @Override
    public JpaRepository<Ad, Long> getDao() {
        return adRepository;
    }
}
