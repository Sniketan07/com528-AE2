package com.shoppingcart.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{

	@Query(value="Select * from orders where customer_id= :customerId", nativeQuery = true)
	OrderModel findByCustomerId(String customerId);

}
