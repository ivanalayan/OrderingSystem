package com.ordering.services;

import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.ordering.models.Product;
import com.ordering.services.impl.ProductServiceImpl;

public class ProductServiceTest {

	@Test
	public void getAllFoods() throws SQLException{
		
		ProductService foodService = new ProductServiceImpl();
		List<Product> allFoods = foodService.getAllProduct();
		Assert.assertEquals(0,allFoods.size());
	}
}
