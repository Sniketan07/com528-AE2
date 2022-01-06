package com.shoppingcart.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_items")
public class OrderItems {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	@JsonBackReference
	private OrderModel orders;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "price", nullable = false)
	private String price;
	
	@Column(name = "quantity", nullable = false)
	private String quantity;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public OrderModel getOrders() {
		return orders;
	}


	public void setOrders(OrderModel orders) {
		this.orders = orders;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	

}
