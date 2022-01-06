package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.application.request.AddItemToShoppingCart;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.ShoppingCartService;

@RestController
@RequestMapping(path="/application")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService shoppingCartService;
	
	@PostMapping(path="/addItemToShoppingCart")
	public Response addItemToShoppingCart(@RequestBody AddItemToShoppingCart request) {
		return shoppingCartService.addItemToShoppingCart(request);
	}
	
	@PostMapping(path="/removeItemFromShoppingCart")
	public Response removeItemFromShoppingCart(@RequestBody String itemCode) {
		return shoppingCartService.removeItemFromShoppingCart(itemCode);
	}
	
	@GetMapping(path="/fetchItemsOfShoppingCart")
	public Response fetchItemsOfShoppingCart(String customerId) {
		return shoppingCartService.fetchItemsOfShoppingCart(customerId);
	}
	
	@PostMapping(path="/updateItemOfShoppingCart")
	public Response updateItemOfShoppingCart(@RequestBody AddItemToShoppingCart request){
		return shoppingCartService.updateItemOfShoppingCart(request);
	}
	
}
