package com.hoc.motobox.controller;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.utils.GenericRestController;
import com.hoc.motobox.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ad")
public class AdController extends GenericRestController<Ad> {

    @Autowired
    public AdController(RestService<Ad> serv) {
        super(serv);
    }

    /**
     * Créé une nouvelle annonce
     * @param ad Objet qui contient les infos de l'annonce
     * @return Ad
     */
    @PostMapping("")
    public Ad createNewAd(@RequestBody Ad ad) {
        return save(ad);
    }

    /**
     * Retourne une annonce par son id
     * @param id Id de l'annonce
     * @return Ad
     */
    @GetMapping("/{id}")
    public Ad getAd(@PathVariable Long id) {
        return findById(id);
    }

    /**
     * Met à jour une annonce
     * @param ad Objet qui contient les infos de l'annonce
     * @return Ad
     */
    @PutMapping("")
    public Ad updateAd(@RequestBody Ad ad) {
        return save(ad);
    }

    /**
     * Supprime une annonce par son id
     * @param id Id de l'annonce
     */
    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        deleteById(id);
    }
}
