package com.order.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.OrderEntity;
import com.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public OrderEntity createOrder(OrderEntity order) {
		order.setOrderId(UUID.randomUUID().toString());
		order.setCreatedAt(LocalDate.now());
		return orderRepository.save(order);
	}

	public OrderEntity getById(String orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}

	public OrderEntity getByUserId(String userId) {

		return orderRepository.findById(userId).orElse(null);
	}

}
