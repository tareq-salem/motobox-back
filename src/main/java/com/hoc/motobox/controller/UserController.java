package com.hoc.motobox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.entity.User;
import com.hoc.motobox.service.AdService;
import com.hoc.motobox.service.UserService;
import com.hoc.motobox.utils.SuperController;
import com.hoc.motobox.utils.SuperRestService;

@RestController
@RequestMapping("/user")
public class UserController extends SuperController<User> {

	@Autowired
	AdService adService;
	@Autowired
	UserService userService;

	public UserController(SuperRestService<User> service) {
		super(service);
	}

	@PostMapping("/ad")
	public Ad saveAd(@RequestBody Ad ad) {
		return adService.save(ad);

	}

	/**
	 * Sert à ajouter une annonce (via son id) au panier d'un utilisateur
	 * 
	 * @param idAd
	 * @param ad   L'Ad à ajouter au panier de l'utilisateur
	 * @return L'Ad qui a été ajoutée au panier
	 */
	
	@PostMapping("/{id}/ads/{idAd}")
	public Ad addAdToCart(@PathVariable Long id, @PathVariable Long idAd) {

		
		return this.userService.addAdToCart(idAd, id);

	}
	
	@DeleteMapping("/{id}/ads/{idAd}")
	public User removeAdFromCart(@PathVariable Long id, @PathVariable Long idAd) {

		
		return this.userService.removeAdFromCart(idAd, id);

	}
	
	

}
