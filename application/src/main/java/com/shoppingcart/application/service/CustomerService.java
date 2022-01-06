package com.shoppingcart.application.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.request.AddCustomer;
import com.shoppingcart.application.request.LoginCustomer;
import com.shoppingcart.application.response.Response;

@Service
public interface CustomerService {

	Response signUp(AddCustomer request);

	Response logIn(LoginCustomer request);

	Response updateCustomer(AddCustomer request);

	Response fetchAllCustomer();

	Response deactivateCustomer(String email);

}
