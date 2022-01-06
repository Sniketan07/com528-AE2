package com.shoppingcart.application.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.request.AddItem;
import com.shoppingcart.application.response.Response;

@Service
public interface ItemService {

	Response addItem(AddItem request);

	Response removeItem(String code);

	Response updateItem(AddItem request);

	Response fetchAllItems();

}
