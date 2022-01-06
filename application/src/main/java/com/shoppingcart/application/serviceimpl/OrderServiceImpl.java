package com.shoppingcart.application.serviceimpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.application.model.CustomerModel;
import com.shoppingcart.application.model.OrderItems;
import com.shoppingcart.application.model.OrderModel;
import com.shoppingcart.application.model.ShoppingCartModel;
import com.shoppingcart.application.repository.CustomerRepository;
import com.shoppingcart.application.repository.OrderItemsRepository;
import com.shoppingcart.application.repository.OrderRepository;
import com.shoppingcart.application.repository.ShoppingCartRepository;
import com.shoppingcart.application.request.AddOrder;
import com.shoppingcart.application.response.Response;
import com.shoppingcart.application.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderItemsRepository orderItemsRepository;
	
	@Override
	public Response addOrder(AddOrder request) {
		Response resp = new Response();
		OrderModel order = new OrderModel();
		List<ShoppingCartModel> cart = shoppingCartRepository.findByCustomerId(request.getCustomerId());
		CustomerModel customer = customerRepository.getById(Long.parseLong(request.getCustomerId()));
		order.setCustomer(customer);
		order.setOrderDate(request.getOrderDate());
		order.setPaymentStatus(request.getPaymentStatus());
		order.setRemark(request.getRemark());
		order = orderRepository.save(order);
		
		if(Objects.isNull(order)) 
		{
			resp.setError(true);
			resp.setMessage("Order not created");
			resp.setResponse(null);
			return resp;
		}
		else
		{
			
			for(int i=0;i<cart.size();i++) {
				OrderItems orderItem = new OrderItems();
				orderItem.setName(cart.get(i).getName());
				orderItem.setPrice(cart.get(i).getTotalPrice());
				orderItem.setQuantity(cart.get(i).getTotalQuantity());
				orderItem.setOrders(order);
				orderItem = orderItemsRepository.save(orderItem);
				
			}
			
			resp.setError(false);
			resp.setMessage("Order created");
			resp.setResponse(order);
		}
		return resp;
	}

	@Override
	public Response updateOrder(AddOrder request) {
		Response resp = new Response();
		OrderModel order = orderRepository.findByCustomerId(request.getCustomerId());
		order.setOrderDate(request.getOrderDate());
		order.setPaymentStatus(request.getPaymentStatus());
		order.setRemark(request.getRemark());
		order = orderRepository.save(order);
		if(Objects.isNull(order)) 
		{
			resp.setError(true);
			resp.setMessage("Order not updated");
			resp.setResponse(null);
		}
		else
		{
			resp.setError(false);
			resp.setMessage("Order updated");
			resp.setResponse(order);
		}
		return resp;
	}

}
