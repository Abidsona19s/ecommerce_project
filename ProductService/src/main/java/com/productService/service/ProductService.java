package com.productService.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productService.model.Product;
import com.productService.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired 
	ProductRepository productRepository;
	
	public Product createProduct(Product product)
	{
		product.setProductId(UUID.randomUUID().toString());
		product.setCreatedAt(LocalDate.now());
		return productRepository.save(product);
	}
	
	
	public Product getProductById(String productId)
	{
		return productRepository.findById(productId).orElse(null);
	}
	
	public Product updateProduct(String productId, Product product)
	{
		Product product2=productRepository.findById(productId).orElse(null);
		if(product2!=null)
		{
			product2.setName(product.getName());
			product2.setDescription(product.getDescription());
			product2.setPrice(product.getPrice());
			product2.setStock(product.getStock());
			return productRepository.save(product2);
		}
		return null;
	}
	
	public void deleteProductById(String productId)
	{
		productRepository.deleteById(productId);
	}

}
