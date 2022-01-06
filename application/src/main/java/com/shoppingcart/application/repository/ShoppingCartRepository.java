package com.shoppingcart.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shoppingcart.application.model.ShoppingCartModel;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartModel, Long>{

	@Query(value="Select * from shoppingcart where item_code= :itemCode", nativeQuery = true)
	ShoppingCartModel fetchAddedItemByCode(String itemCode);

	@Query(value="Select * from shoppingcart where shoppingcart_id= :shoppingcartid", nativeQuery = true)
	ShoppingCartModel findByShoppingCartId(String shoppingcartid);
	
	
	@Query(value="Select * from shoppingcart where customer_id= :customerId", nativeQuery = true)
	List<ShoppingCartModel> findByCustomerId(String customerId);


}
