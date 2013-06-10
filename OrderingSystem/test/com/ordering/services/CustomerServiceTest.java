package com.ordering.services;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;

import org.junit.Test;

import com.ordering.exceptions.LoginFailedException;
import com.ordering.services.impl.CustomerServicesImpl;

public class CustomerServiceTest {

	@Test(expected=LoginException.class)
	public void loginWithLoginFailed() throws SQLException, LoginFailedException{
		CustomerService customerService = new CustomerServicesImpl();
					    customerService.validateAccount("myusername", "mypassword");
	}
	
}
