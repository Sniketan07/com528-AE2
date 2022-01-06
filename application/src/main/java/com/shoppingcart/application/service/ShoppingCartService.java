package com.shoppingcart.application.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.request.AddItemToShoppingCart;
import com.shoppingcart.application.response.Response;

@Service
public interface ShoppingCartService {

	Response addItemToShoppingCart(AddItemToShoppingCart request);

	Response removeItemFromShoppingCart(String itemCode);

	Response fetchItemsOfShoppingCart(String customerId);

	Response updateItemOfShoppingCart(AddItemToShoppingCart request);

}
