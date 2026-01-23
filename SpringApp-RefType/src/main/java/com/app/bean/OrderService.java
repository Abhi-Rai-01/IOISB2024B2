package com.app.bean;

public class OrderService {
	private Customer customer;
	private Product product;
	
	public OrderService(Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}
	
	//business logic
	public void order() {
		System.out.println(product.getPname() + " is purchased by the customer: " + customer.getCname());
	}
}
