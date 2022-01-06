package com.shoppingcart.application.serviceimpl;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shoppingcart.application.model.CustomerModel;
import com.shoppingcart.application.model.ItemModel;
import com.shoppingcart.application.model.ShoppingCartModel;
import com.shoppingcart.application.repository.CustomerRepository;
import com.shoppingcart.application.repository.ItemRepository;
import com.shoppingcart.application.repository.ShoppingCartRepository;
import com.shoppingcart.application.request.AddItemToShoppingCart;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Response addItemToShoppingCart(AddItemToShoppingCart request) {
		Response resp = new Response();
		ItemModel item = itemRepository.getByCode(request.getItemCode());
		ShoppingCartModel cart = new ShoppingCartModel();
		cart.setItemCode(request.getItemCode());
		cart.setName(item.getName());
		CustomerModel customer = customerRepository.checkEmail(request.getCustomerEmail());
		cart.setCustomerId(customer.getId());
		long a = Long.parseLong(item.getPrice());
		long b = Long.parseLong(request.getQuantity());
		cart.setTotalPrice(String.valueOf(a*b));
		cart.setTotalQuantity(request.getQuantity());
		cart = shoppingCartRepository.save(cart);
		if(Objects.isNull(cart)) 
		{
			resp.setError(true);
			resp.setMessage("Item Not Added to Cart.");
			resp.setResponse(null);
		}
		else 
		{
			resp.setError(false);
			resp.setMessage("Item added to cart");
			resp.setResponse(cart);
		}
		return resp;
	}

	@Override
	public Response removeItemFromShoppingCart(String itemCode) {
		Response resp = new Response();
		ShoppingCartModel cart = shoppingCartRepository.fetchAddedItemByCode(itemCode);
		try{
			shoppingCartRepository.delete(cart);
			resp.setError(false);
			resp.setMessage("Added item Deleted.");
			resp.setResponse(cart);
		}catch(Exception e) {
			resp.setError(true);
			resp.setMessage("Added item Not Deleted.");
			resp.setResponse(null);
		}
		return resp;
	}

	@Override
	public Response fetchItemsOfShoppingCart(String customerId) {
		Response resp = new Response();
		List<ShoppingCartModel> listOfItems = shoppingCartRepository.findByCustomerId(customerId);
		if(Objects.isNull(listOfItems)) 
		{
			resp.setError(true);
			resp.setMessage("Items Not Found.");
			resp.setResponse(null);
		}
		else 
		{
			resp.setError(false);
			resp.setMessage("Items Found");
			resp.setResponse(listOfItems);
		}
		return resp;
	}

	@Override
	public Response updateItemOfShoppingCart(AddItemToShoppingCart request) {
		Response resp = new Response();
		ShoppingCartModel cart = shoppingCartRepository.fetchAddedItemByCode(request.getItemCode());	
		ItemModel item = itemRepository.getByCode(request.getItemCode());
		long a = Long.parseLong(item.getPrice());
		long b = Long.parseLong(request.getQuantity());
		cart.setTotalPrice(String.valueOf(a*b));
		cart.setTotalQuantity(request.getQuantity());
		cart = shoppingCartRepository.save(cart);
		if(Objects.isNull(cart)) 
		{
			resp.setError(true);
			resp.setMessage("Unable to update item");
			resp.setResponse(null);
		}
		else 
		{
			resp.setError(false);
			resp.setMessage("Item updated");
			resp.setResponse(cart);
		}
		return resp;
	}
	
	
	

}
