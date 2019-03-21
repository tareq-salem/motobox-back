package com.hoc.motobox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.repository.AdRepository;
import com.hoc.motobox.utils.SuperRestService;

@Service
public class AdService implements SuperRestService<Ad> {

    @Autowired
    private AdRepository adRepository;

    @Override
    public JpaRepository<Ad, Long> getDao() {
        return adRepository;
    }

    public Ad loadAdsByTitle(String searchTitle) throws Exception {
        Ad ad = adRepository.findAdsByTitleContains(searchTitle);
        if (ad == null) {
            throw new Exception(searchTitle);
        }
        // return new Ad(ad.getTitle(), ad.getCategory());
        return ad;
    }

    @Override
    public Ad update(Long id, Ad t) {
        // TODO Auto-generated method stub
        return null;
    }

}
