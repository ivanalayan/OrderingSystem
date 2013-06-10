package com.ordering.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Cart;
import com.ordering.models.Customer;
import com.ordering.models.Product;
import com.ordering.services.CartService;
import com.ordering.services.ProductService;
import com.ordering.services.impl.CartServiceImpl;
import com.ordering.services.impl.ProductServiceImpl;


public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MenuServlet() {
        super();
    }

	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(req, resp);
    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			ProductService productService = new ProductServiceImpl();
			List<Product> allFoods = productService.getAllProduct();
			req.setAttribute("foods", allFoods);
							  
			Customer customer = (Customer) req.getSession().getAttribute("account");
			CartService cartService = new CartServiceImpl(customer);
			Cart cart = cartService.getCustomerCart();
			req.setAttribute("cartitems", cart.getItems());
			RequestDispatcher rd = req.getRequestDispatcher("/views/order/menu.jsp");
							  rd.forward(req, resp);			
							
		} catch (OrderingSystemDBException e) {
		
		}
		
	}
}
