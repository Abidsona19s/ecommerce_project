package com.ecommerce.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ECommercePaymentSrviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePaymentSrviceApplication.class, args);
	}

}