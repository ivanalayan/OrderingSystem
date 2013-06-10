package com.ordering.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ordering.dao.ProductDAO;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Product;

public class ProductDAOMysqlImp implements ProductDAO {

	private PreparedStatement statement;
	private MysqlDatabaseConnector connector;

	public ProductDAOMysqlImp() {
		try {
			connector = new MysqlDatabaseConnector();
		} catch (OrderingSystemDBException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Product> fetchAllProduct() throws OrderingSystemDBException {
		List<Product> product = new ArrayList<Product>();
		try {
			Connection connection = connector.getConnection();
			String sql = "SELECT * FROM `product`";
			statement = connection.prepareStatement(sql);
			ResultSet queryResult = statement.executeQuery();
			while (queryResult.next()) {
				long id = queryResult.getLong("id");
				String foodName = queryResult.getString("name");
				BigDecimal price = BigDecimal.valueOf(queryResult
						.getDouble("price"));
				int qty = queryResult.getInt("qty");
				product.add(new Product(id, foodName, qty, price));
			}
		} catch (SQLException exception) {
			throw new OrderingSystemDBException("Database connection failed: "
					+ exception.getMessage());
		}
		return product;
	}

	@Override
	public Product getProductById(long productId) {
		Product product = new Product();
		try {
			Connection connection = connector.getConnection();
			String sql = "SELECT * FROM `product` where id = ?";
			statement = connection.prepareStatement(sql);
			statement.setLong(1, productId);
			ResultSet queryResult = statement.executeQuery();
			queryResult.first();
			long id = queryResult.getLong("id");
			String foodName = queryResult.getString("name");
			BigDecimal price = BigDecimal.valueOf(queryResult
					.getDouble("price"));
			int qty = queryResult.getInt("qty");
				
			product.setId(id);
			product.setName(foodName);
			product.setQty(qty);
			product.setPrice(price);
			
			return product;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return product;
	}

}
