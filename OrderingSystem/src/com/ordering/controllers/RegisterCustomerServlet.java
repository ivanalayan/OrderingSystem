package com.ordering.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;
import com.ordering.services.CustomerService;
import com.ordering.services.impl.CustomerServicesImpl;

public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterCustomerServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String username = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		String address = request.getParameter("address").trim();
		SimpleDateFormat formatBirthday = new SimpleDateFormat("yyyy-mm-dd");
		Date birthday = null;
		try {
			birthday = formatBirthday.parse(request.getParameter("birthday")
					.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setBirthday(birthday);
		customer.setAddress(address);
		
		CustomerService customerService = null;
		try {
			customerService = new CustomerServicesImpl();
			customerService.addNewCustomer(customer);
			RequestDispatcher rd = request
					.getRequestDispatcher("/login");
				rd.forward(request, response);
		} catch (UsernameAlreadyExistException message) {
			request.setAttribute("errorMessages", message.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/register");
				rd.forward(request, response);
		
		} catch (OrderingSystemDBException e) {
			request.setAttribute("errorMessages", e.getMessage());
			RequestDispatcher rd = request
					.getRequestDispatcher("/register");
				rd.forward(request, response);
		}  

	}

}
