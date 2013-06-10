package com.ordering.services;

import com.ordering.models.Cart;
import com.ordering.services.impl.CartException;

public interface CartService {

	public void checkOut(long productId, long qtyOrdered);
	public void addToCart(long productId, int qtyOrdered) throws CartException;
	public Cart getCustomerCart();
}
