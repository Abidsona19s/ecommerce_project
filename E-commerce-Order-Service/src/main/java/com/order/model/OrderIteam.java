package com.order.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderIteam {
	private String productId;
	private int quantity;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderIteam [productId=" + productId + ", quantity=" + quantity + "]";
	}
	

}
