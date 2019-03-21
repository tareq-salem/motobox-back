package com.hoc.motobox.controller;

import com.hoc.motobox.entity.Ad;
import com.hoc.motobox.entity.User;
import com.hoc.motobox.service.AdService;
import com.hoc.motobox.service.UserService;
import com.hoc.motobox.utils.SuperController;
import com.hoc.motobox.utils.SuperRestService;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@PostMapping("/addToCart/ads/{idAd}")
	public Ad addAdToCart(@PathVariable Long idAd) {

		
		return this.userService.addAdToCart(idAd);

	}
	
	@DeleteMapping("/remove/ads/{idAd}")
	public User removeAdFromCart(@PathVariable Long idAd) {

		
		return this.userService.removeAdFromCart(idAd);

	}
	
	@GetMapping("/cart")
	public Set<Ad> getCart(){
		return this.userService.getCart();
	}
	

}
