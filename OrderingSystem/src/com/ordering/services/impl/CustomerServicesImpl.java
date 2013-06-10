package com.ordering.services.impl;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ordering.dao.CustomerDAO;
import com.ordering.dao.impl.CustomerDAOMysqlImp;
import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.exceptions.RegistrationFailedException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;
import com.ordering.services.CustomerService;

public class CustomerServicesImpl implements CustomerService {

	
	private CustomerDAO customerDAO;

	public CustomerServicesImpl() throws OrderingSystemDBException{
		customerDAO = new CustomerDAOMysqlImp();
	}

	
	@Override
	public Customer validateAccount(String username, String password)throws LoginFailedException, OrderingSystemDBException {
		
		CustomerDAO customerDAO= new CustomerDAOMysqlImp();
		Customer cust = customerDAO.getCustomerDetailsAccountOf(username,password);
		return cust;
	}

	@Override
	public void addNewCustomer(Customer customer)throws OrderingSystemDBException, UsernameAlreadyExistException {
			customerDAO.addCustomer(customer);
	}
	
	

}
