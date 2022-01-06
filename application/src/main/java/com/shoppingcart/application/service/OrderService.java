package com.shoppingcart.application.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.request.AddOrder;
import com.shoppingcart.application.response.Response;

@Service
public interface OrderService {

	Response addOrder(AddOrder request);

	Response updateOrder(AddOrder request);

}
