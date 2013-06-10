package com.ordering.services.impl;

import com.ordering.dao.CartDAO;
import com.ordering.dao.ProductDAO;
import com.ordering.dao.impl.CartDAOMysqlImpl;
import com.ordering.dao.impl.ProductDAOMysqlImp;
import com.ordering.models.Cart;
import com.ordering.models.Customer;
import com.ordering.models.Product;
import com.ordering.services.CartService;
import com.ordering.services.ProductService;

public class CartServiceImpl implements CartService {

	
	private Customer customer;
	
	public CartServiceImpl( Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public void checkOut(long productId, long qtyOrdered) {
		
	}

	@Override
	public void addToCart(long productId, int qtyOrdered)throws CartException{
		    CartDAO cart = new CartDAOMysqlImpl();
		    ProductDAO productDAO = new ProductDAOMysqlImp();
		    Product product = productDAO.getProductById(productId); 
			int stock = product.getQty();
		    if((stock-qtyOrdered)>0)
		    {
		    	if(!cart.addToCart(customer.getId(),productId,qtyOrdered))
						throw new CartException("Unable to add the item to cart");
		    }
		    else{
		    	throw new CartException("Insufficient stock for "+product.getName());
		    }
	}

	@Override
	public Cart getCustomerCart() {
	    CartDAO cartDAO = new CartDAOMysqlImpl();
	    Cart customerCart = cartDAO.getCartItemsByCustomer(customer.getId());
	 	
	    return customerCart;
	}
	
}
