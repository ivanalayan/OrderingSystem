package com.ordering.services;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;

public interface CustomerService {

	public Customer validateAccount(String username, String password)throws OrderingSystemDBException, LoginFailedException;
	public void addNewCustomer(Customer customer) throws OrderingSystemDBException, UsernameAlreadyExistException;

}
