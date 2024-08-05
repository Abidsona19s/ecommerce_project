package com.ecommerce.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.payment.model.Payment;
@Repository
public interface PayementRepository extends JpaRepository<Payment, String>{
	
	public Payment findByOrderId(String orderId);

}