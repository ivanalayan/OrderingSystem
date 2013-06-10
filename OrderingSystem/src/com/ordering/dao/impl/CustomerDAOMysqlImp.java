package com.ordering.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ordering.dao.CustomerDAO;
import com.ordering.exceptions.LoginFailedException;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.exceptions.UsernameAlreadyExistException;
import com.ordering.models.Customer;

public class CustomerDAOMysqlImp implements CustomerDAO {

	private MysqlDatabaseConnector connector;
	private PreparedStatement statement;

	public CustomerDAOMysqlImp() throws OrderingSystemDBException {
			connector = new MysqlDatabaseConnector();
	}

	@Override
	public Customer getCustomerDetailsAccountOf(String username, String password)
			throws OrderingSystemDBException, LoginFailedException {
		Customer cust = null;
		ResultSet queryResult;

		try {
			Connection connection = getConnection();
			String sql = "SELECT * FROM `Customer` WHERE "
					+ "username = ? and password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			queryResult = statement.executeQuery();
			if(!(queryResult.next()))
				throw new LoginFailedException("Invalid login details!");
			long custId = queryResult.getLong("id");
			String fname = queryResult.getString("firstname");
			String lname = queryResult.getString("lastname");
			Date bday = queryResult.getDate("birthday");
			String address = queryResult.getString("address");
			Date registeredDate = queryResult.getDate("registered_date");
			Date lastOrderDate = queryResult.getDate("last_ordered_date");
			cust = new Customer(custId, fname, lname,username,password, bday, registeredDate, lastOrderDate, address);
			connection.close();
		} catch (SQLException e) {
			throw new OrderingSystemDBException("Failed to connect to database: "+e.toString());
		}
		
		
		return cust;
	}

	@Override
	public void addCustomer(Customer customer)
			throws OrderingSystemDBException,UsernameAlreadyExistException {

		try {
			Connection connection = getConnection();
			String sql = "INSERT INTO `OrderingSystem`.`Customer`(`firstname`,`lastname`,`username`,`password`,`birthday`,`address`,`registered_date`)";
			sql += "VALUES(?,?,?,?,?,?,curdate());";
			statement = (PreparedStatement) connection.prepareStatement(
					sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getUsername());
			statement.setString(4, customer.getPassword());
			java.util.Date bday = customer.getBirthday();
			statement.setDate(5,new Date(bday.getYear(), bday.getMonth(), bday.getDay()));
			statement.setString(6, customer.getAddress());
			statement.execute();
			connection.close();
		}
		catch (MySQLIntegrityConstraintViolationException message){
				throw new UsernameAlreadyExistException(customer.getUsername() +" already exist");
		}
		catch (SQLException e) {
				throw new OrderingSystemDBException("Failed to connect to database: "+e.toString());
		}

	}

	public Connection getConnection() {
		return connector.getConnection();
	}



}
