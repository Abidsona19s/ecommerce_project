package com.order.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class OrderEntity {
	@Id
	private String OrderId;
	private String userId;
	@ElementCollection
	private List<OrderIteam> product;
	private double totalAmount;
	private String status;
	private LocalDate createdAt;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<OrderIteam> getProduct() {
		return product;
	}
	public void setProduct(List<OrderIteam> product) {
		this.product = product;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "OrderEntity [OrderId=" + OrderId + ", userId=" + userId + ", product=" + product + ", totalAmount="
				+ totalAmount + ", status=" + status + ", createdAt=" + createdAt + "]";
	}
	
	
	
	
	

}
