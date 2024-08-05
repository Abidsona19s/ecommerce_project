package com.ecommerce.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ECommerceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApiGatewayApplication.class, args);
	}

}
