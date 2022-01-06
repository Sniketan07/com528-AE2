package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.application.request.AddItem;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.ItemService;

@RestController
@RequestMapping(path="/application")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping(path="/addItem")
	public Response addItem(@RequestBody AddItem request) {
		return itemService.addItem(request);
	}
	
	@PostMapping(path="/removeItem")
	public Response removeItem(@RequestBody String code) {
		return itemService.removeItem(code);
	}
	
	@PostMapping(path="/updateItem")
	public Response updateItem(@RequestBody AddItem request) {
		return itemService.updateItem(request);
	}
	
	@GetMapping(path="/fetchAllItems")
	public Response fetchAllItems() {
		return itemService.fetchAllItems();
	}
}
