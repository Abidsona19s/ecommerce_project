package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.OrderEntity;
import com.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/create")
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order)
	{
		order=orderService.createOrder(order);
		return  ResponseEntity.ok(order);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderEntity> getById(@PathVariable String orderId)
	{
		try {
			OrderEntity orderEntity=orderService.getById(orderId);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderEntity);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<OrderEntity> getByUserId(@PathVariable String userId)
	{
		try {
			OrderEntity orderEntity=orderService.getByUserId(userId);
			if(userId.equals(orderEntity.getUserId()))
			{
			System.out.println(orderEntity);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderEntity);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
}
