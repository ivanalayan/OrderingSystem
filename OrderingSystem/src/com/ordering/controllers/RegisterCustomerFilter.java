package com.ordering.controllers;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterCustomerFilter implements Filter {


    public RegisterCustomerFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String errorMessages =createErrorMessage(request);

		if (errorMessages.length() > 0) {
			request.setAttribute("errorMessages", errorMessages);
			RequestDispatcher rd = request
					.getRequestDispatcher("register.jsp");
				rd.forward(request, response);

		}else{
			chain.doFilter(request, response);
		}
	}

	private String createErrorMessage(ServletRequest request) {
		String firstName = request.getParameter("firstName").trim();
		String lastName = request.getParameter("lastName").trim();
		String username = request.getParameter("userName").trim();
		String password = request.getParameter("password").trim();
		String address = request.getParameter("address").trim();
		String birthday = request.getParameter("birthday").trim();

		StringBuilder errorMessages = new StringBuilder();
		if (firstName.isEmpty()) {
			errorMessages.append("firstname is empty ");
		}
		if (lastName.isEmpty()) {
			errorMessages.append("lastname is empty ");

		}
		if (username.isEmpty()) {
			errorMessages.append("username is empty ");
		}
		if (password.isEmpty()) {
			errorMessages.append("password is empty ");
		}
		if (birthday.isEmpty()) {
			errorMessages.append("birthday is empty ");
		}
		if (address.isEmpty()) {
			errorMessages.append("address is empty ");
		}

		return errorMessages.toString();
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
