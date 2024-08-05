package com.ecommerce.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@PostMapping("/paymentprocess")
	public ResponseEntity<Payment> paymentProcess(@RequestBody Payment payment) {
		Payment payment2 = paymentService.processPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).body(payment2);
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentDetailByPaymentId(@PathVariable String paymentId) {
		Payment payment = paymentService.getById(paymentId);
		return ResponseEntity.status(HttpStatus.FOUND).body(payment);
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Payment> getPaymentDetailsByOrderId(@PathVariable String orderId) {
		try {
			Payment payment = paymentService.getByOrderId(orderId);
			return ResponseEntity.status(HttpStatus.FOUND).body(payment);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}

}
