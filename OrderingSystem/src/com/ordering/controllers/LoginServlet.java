package com.ordering.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Customer;
import com.ordering.services.CustomerService;
import com.ordering.services.impl.CustomerServicesImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		CustomerService customerService = null;
		try {
			customerService = new CustomerServicesImpl();
			Customer cust = customerService.validateAccount(username, password);
			HttpSession customerSession = request.getSession();
						customerSession.setAttribute("account", cust);
			RequestDispatcher rd = request
					.getRequestDispatcher("/menu");
				rd.forward(request, response);
		}catch (LoginFailedException e) {
			request.setAttribute("errorMessages", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/login");
				rd.forward(request, response);
		} 
		catch (OrderingSystemDBException e) {
			request.setAttribute("errorMessages", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/login");
				rd.forward(request, response);
		}  	
	}

}
