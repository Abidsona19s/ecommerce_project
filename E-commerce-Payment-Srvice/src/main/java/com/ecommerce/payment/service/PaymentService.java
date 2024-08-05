package com.ecommerce.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.payment.exception.ResourceNotFoundException;
import com.ecommerce.payment.model.Payment;
import com.ecommerce.payment.repository.PayementRepository;

@Service
public class PaymentService {

	@Autowired
	PayementRepository payementRepository;

	public Payment processPayment(Payment payment) {
		return payementRepository.save(payment);
	}

	public Payment getById(String paymentId) {
		return payementRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public Payment getByOrderId(String orderId)
	{
		return payementRepository.findByOrderId(orderId);
	}

}
