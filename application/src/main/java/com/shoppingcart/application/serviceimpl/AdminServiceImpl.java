package com.shoppingcart.application.serviceimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.model.AdminModel;
import com.shoppingcart.application.repository.AdminRepository;
import com.shoppingcart.application.request.LoginAdmin;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepository;
	
	
	@Override
	public Response adminLogin(LoginAdmin request) {
		Response resp = new Response();
		AdminModel admin = adminRepository.checkCredentials(request.getEmail(),request.getPassword());
		if(Objects.isNull(admin)) 
		{
			resp.setError(true);
			resp.setMessage("Invalid credentials. Please try again.");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Login successful.");
			resp.setResponse(admin);
		}	
		return resp;
	}

}
