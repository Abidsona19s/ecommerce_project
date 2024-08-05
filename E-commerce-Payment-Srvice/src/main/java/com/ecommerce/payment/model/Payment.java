package com.ecommerce.payment.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payment_table")
public class Payment {
	@Id
	private String paymentId;
	private String orderId;
	private double amount;
	private String status;
	private LocalDate createdAt;

}
