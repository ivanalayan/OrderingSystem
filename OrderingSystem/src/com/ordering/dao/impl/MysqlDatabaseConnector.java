package com.ordering.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ordering.exceptions.OrderingSystemDBException;

public class MysqlDatabaseConnector {
	
	public static String USERNAME = "root";
	public static String PASSWORD = "root";
	public static String SCHEMA = "OrderingSystem";
	public static String URL_CONNECTION = "jdbc:mysql://localhost:3306/";
	private Connection connector;
	
	public MysqlDatabaseConnector() throws OrderingSystemDBException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			throw new OrderingSystemDBException("Database conneciton failed: "+e.getMessage());
		}	
		try {
			initializeConnection();
		} catch (SQLException e) {
			throw new OrderingSystemDBException("Database conneciton failed: "+e.getMessage());
		}
	}
	
	private void initializeConnection()throws SQLException{
		connector = DriverManager.getConnection(URL_CONNECTION.concat(SCHEMA), USERNAME, PASSWORD);
	}
	
	public Connection getConnection(){
			return this.connector;
	}
}
