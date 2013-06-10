package com.ordering.models;

import java.math.BigDecimal;

public class Product {
	
	private long foodId;
	private String name;
	private int qty;
	private BigDecimal price;
	
	public Product(long foodId, String name, int qty, BigDecimal price) {
		this.foodId = foodId;
		this.name = name;
		this.qty = qty;
		this.setPrice(price);
	}

	public Product() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (foodId ^ (foodId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (foodId != other.foodId)
			return false;
		return true;
	}

	public long getId() {
		return foodId;
	}

	public void setId(long id) {
		this.foodId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getPrice() {
		return new BigDecimal(price.toString());
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	
}
