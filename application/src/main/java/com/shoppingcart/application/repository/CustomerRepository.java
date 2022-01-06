package com.shoppingcart.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

	@Query(value="Select * from customer where email= :email", nativeQuery = true)
	CustomerModel checkEmail(String email);

	@Query(value="Select * from customer where email= :email and password= :password", nativeQuery = true)
	CustomerModel checkCredentials(String email, String password);


}
