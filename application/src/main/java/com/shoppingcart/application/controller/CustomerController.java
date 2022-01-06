package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.application.request.AddCustomer;
import com.shoppingcart.application.request.LoginCustomer;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.CustomerService;

@RestController
@RequestMapping(path="/application")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping(path="/signUp")
	public Response signUp(@RequestBody AddCustomer request) {
		return customerService.signUp(request);
	}
	
	@PostMapping(path="/logIn")
	public Response logIn(@RequestBody LoginCustomer request) {
		return customerService.logIn(request);
	}
	
	@PostMapping(path="/updateCustomer")
	public Response updateCustomer(@RequestBody AddCustomer request) {
		return customerService.updateCustomer(request);
	}
	
	@GetMapping(path="/fetchAllCustomer")
	public Response fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}
	
	@PostMapping(path="/deactivateCustomer")
	public Response deactivateCustomer(String email) {
		return customerService.deactivateCustomer(email);
	}
}
