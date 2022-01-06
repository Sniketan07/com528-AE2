package com.shoppingcart.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.model.CustomerModel;
import com.shoppingcart.application.repository.CustomerRepository;
import com.shoppingcart.application.request.AddCustomer;
import com.shoppingcart.application.request.LoginCustomer;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public Response signUp(AddCustomer request) {
		Response resp = new Response();
		CustomerModel customer = new CustomerModel();
		customer.setEmail(request.getEmail());
		customer.setPassword(request.getPassword());
		customer.setName(request.getName());
		customer.setAddress(request.getAddress());
		customer.setCreditcardno(null);
		customer = customerRepository.save(customer);
		if(Objects.isNull(customer)) 
		{
			resp.setError(true);
			resp.setMessage("Sign up unsuccessful. Please try again later.");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Sign up successful. Please login.");
			resp.setResponse(customer);
		}
		return resp;
	}


	@Override
	public Response logIn(LoginCustomer request) {
		Response resp = new Response();
		CustomerModel customer = customerRepository.checkEmail(request.getEmail());
		if(Objects.isNull(customer)) 
		{
			resp.setError(true);
			resp.setMessage("You are not a member. Please signup");
			resp.setResponse(null);
			return resp;
		}
		CustomerModel customer1 = customerRepository.checkCredentials(request.getEmail(),request.getPassword());
		if(Objects.isNull(customer1)) 
		{
			resp.setError(true);
			resp.setMessage("Invalid credentials. Please try again.");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Login successful.");
			resp.setResponse(customer1);
		
		}	
		return resp;
	}


	@Override
	public Response updateCustomer(AddCustomer request) {
		Response resp = new Response();
		CustomerModel customer = customerRepository.checkEmail(request.getEmail());
		if(Objects.isNull(customer)) 
		{
			resp.setError(true);
			resp.setMessage("Customer could not be found");
			resp.setResponse(null);
			return resp;
		}
		customer.setEmail(request.getEmail());
		customer.setPassword(request.getPassword());
		customer.setName(request.getName());
		customer.setAddress(request.getAddress());
		customer.setCreditcardno(request.getCreditcardno());
		customer = customerRepository.save(customer);
		if(Objects.isNull(customer)) 
		{
			resp.setError(true);
			resp.setMessage("Customer could not be updated");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Customer updated successfully");
			resp.setResponse(customer);
		}
		return resp;
	}


	@Override
	public Response fetchAllCustomer() {
		Response resp = new Response();
		List<CustomerModel> customers = new ArrayList<CustomerModel>();
		customers = customerRepository.findAll();
		if(customers.size()>0)
		{
			resp.setError(false);
			resp.setMessage("Customer list fetched successfully");
			resp.setResponse(customers);
		}
		else
		{
			resp.setError(true);
			resp.setMessage("Customer list empty");
			resp.setResponse(null);
		}
		return resp;
	}


	@Override
	public Response deactivateCustomer(String email) {
		Response resp = new Response();
		CustomerModel customer = customerRepository.checkEmail(email);
		if(Objects.isNull(customer)) 
		{
			resp.setError(true);
			resp.setMessage("Customer could not be found");
			resp.setResponse(null);
			return resp;
		}
		customer.setIsDeactivated(true);
		customer = customerRepository.save(customer);
		resp.setError(false);
		resp.setMessage("Customer deactivated successfully");
		resp.setResponse(customer);
		return resp;
	}

}
