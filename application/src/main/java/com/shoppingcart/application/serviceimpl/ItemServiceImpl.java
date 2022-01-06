package com.shoppingcart.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.model.ItemModel;
import com.shoppingcart.application.repository.ItemRepository;
import com.shoppingcart.application.request.AddItem;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Response addItem(AddItem request) {
		Response resp = new Response();
		ItemModel item = new ItemModel();
		item.setCode(request.getItemCode());
		item.setName(request.getName());
		item.setPrice(request.getPrice());
		item.setQuantity(request.getQuantity());
		item = itemRepository.save(item);
		if(Objects.isNull(item)) 
		{
			resp.setError(true);
			resp.setMessage("Item Not Saved.");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Item Saved.");
			resp.setResponse(item);
		}
		
		
		return resp;
	}

	@Override
	public Response removeItem(String code) {
		Response resp = new Response();
		ItemModel item = itemRepository.getByCode(code);
		try{
			itemRepository.delete(item);
			resp.setError(false);
			resp.setMessage("Item Deleted.");
			resp.setResponse(item);
		}catch(Exception e) {
			resp.setError(true);
			resp.setMessage("Item Not Deleted.");
			resp.setResponse(null);
		}
		return resp;
	}

	@Override
	public Response updateItem(AddItem request) {
		Response resp = new Response();
		ItemModel item = itemRepository.getByCode(request.getItemCode());
		item.setName(request.getName());
		item.setPrice(request.getPrice());
		item.setQuantity(request.getQuantity());
		item = itemRepository.save(item);
		if(Objects.isNull(item)) 
		{
			resp.setError(true);
			resp.setMessage("Item Not Saved.");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Item Saved.");
			resp.setResponse(item);
		}
		
		
		return resp;
	}

	@Override
	public Response fetchAllItems() {
		Response resp = new Response();
		List<ItemModel> items = new ArrayList<ItemModel>();
		items = itemRepository.findAll();
		if(items.size()>0)
		{
			resp.setError(false);
			resp.setMessage("Item list fetched successfully");
			resp.setResponse(items);
		}
		else
		{
			resp.setError(true);
			resp.setMessage("Item list empty");
			resp.setResponse(null);
		}
		return resp;
	}

}
