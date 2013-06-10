package com.ordering.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordering.models.Customer;
import com.ordering.services.CartService;
import com.ordering.services.impl.CartException;
import com.ordering.services.impl.CartServiceImpl;

public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToCart() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long productId = Long.parseLong(request.getParameter("productId"));
		int qtyOrdered = Integer.parseInt(request.getParameter("qtyOrdered"));
		
		Customer customer = (Customer) request.getSession().getAttribute("account");
		CartService cartService = new CartServiceImpl(customer);
		try {
			cartService.addToCart(productId, qtyOrdered);
		} catch (CartException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/menu");
						  rd.forward(request, response);
	}

}
