package com.shoppingcart.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoppingcart.application.request.LoginAdmin;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.AdminService;

@RestController
@RequestMapping(path="/application")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping(path="/adminLogin")
	public Response adminLogin(@RequestBody LoginAdmin request) {
		return adminService.adminLogin(request);
	}
	
	
}
