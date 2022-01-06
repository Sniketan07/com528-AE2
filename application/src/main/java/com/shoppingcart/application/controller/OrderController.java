package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.application.request.AddOrder;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.OrderService;

@RestController
@RequestMapping(path="/application")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	
	@PostMapping(path="/addOrder")
	public Response addOrder(@RequestBody AddOrder request) {
		return orderService.addOrder(request);
	}
	
	@PostMapping(path="/updateOrder")
	public Response updateOrder(@RequestBody AddOrder request) {
		return orderService.updateOrder(request);
	}
}
