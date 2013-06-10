package com.ordering.dao;

import java.sql.SQLException;
import java.util.List;

import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Product;

public interface ProductDAO {

	public List<Product> fetchAllProduct() throws OrderingSystemDBException;
	
	public Product getProductById(long productId);
	
}
