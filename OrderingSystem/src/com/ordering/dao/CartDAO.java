package com.ordering.dao;

import com.ordering.models.Cart;


public interface CartDAO {


	public boolean addToCart(long custId, long prodId, int qty);

	public Cart getCartItemsByCustomer(long id);
	

}
