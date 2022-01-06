package com.shoppingcart.application.service;

import org.springframework.stereotype.Service;

import com.shoppingcart.application.request.LoginAdmin;
import com.shoppingcart.application.response.Response;

@Service
public interface AdminService {

	Response adminLogin(LoginAdmin request);

}
