package com.shoppingcart.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shoppingcart.application.model.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Long>{

	@Query(value="Select * from item where code= :itemCode", nativeQuery = true)
	ItemModel getByCode(String itemCode);

}
