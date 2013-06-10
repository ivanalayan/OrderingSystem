package com.ordering.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ordering.dao.CartDAO;
import com.ordering.dao.ProductDAO;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Cart;
import com.ordering.models.Product;

public class CartDAOMysqlImpl implements CartDAO {

	private MysqlDatabaseConnector connector;
	private PreparedStatement statement;
	
	public CartDAOMysqlImpl() {
		try {
			connector = new MysqlDatabaseConnector();
		} catch (OrderingSystemDBException e) {

			e.printStackTrace();
		}	
	}
	
	@Override
	public boolean addToCart(long custId,long prodId,int qty) {

		try {
			Connection connection = connector.getConnection();
			String sql = "INSERT INTO `cart`(`customer_id`,`product_id`,`qty`)";
			sql += "VALUES(?,?,?);";
			statement = (PreparedStatement) connection.prepareStatement(
					sql);
			statement.setLong(1, custId);
			statement.setLong(2, prodId);
			statement.setLong(3, qty);
			return !statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public Cart getCartItemsByCustomer(long id) {
		
		Cart cart = new Cart();
		try {
			Connection connection = connector.getConnection();
			String sql = "SELECT * FROM `cart` WHERE customer_id = ?";
			statement = (PreparedStatement) connection.prepareStatement(
					sql);
			statement.setLong(1, id);
			ResultSet rs = statement.executeQuery();
			ProductDAO productDAO = new ProductDAOMysqlImp();
			while(rs.next())
			{   
				cart.setCartId(rs.getLong("id"));
				cart.setCustomerId(rs.getLong("customer_id"));
				long productId = rs.getLong("product_id");
				Product productInfo = productDAO.getProductById(productId);
					    productInfo.setQty(rs.getInt("qty"));
				cart.addItemsToCart(productInfo);	    
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

}
