package com.ordering.services.impl;

import java.util.List;

import com.ordering.dao.ProductDAO;
import com.ordering.dao.impl.ProductDAOMysqlImp;
import com.ordering.exceptions.OrderingSystemDBException;
import com.ordering.models.Product;
import com.ordering.services.ProductService;

public class ProductServiceImpl implements ProductService{

	private ProductDAO productDAO = null;
	public ProductServiceImpl() throws OrderingSystemDBException {
		productDAO = new ProductDAOMysqlImp();
	}
	@Override
	public List<Product> getAllProduct() throws OrderingSystemDBException {
		return productDAO.fetchAllProduct();
	}	
}
 