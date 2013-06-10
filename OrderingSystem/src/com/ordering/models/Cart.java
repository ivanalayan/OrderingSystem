package com.ordering.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	

	private long customerId;
	private long cartId;
	private List<Product> items = new ArrayList<Product>();

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public List<Product> getItems() {
		return items;
	}
	
	public void addItemsToCart(Product product){
			this.items.add(product);
	}

	
}
