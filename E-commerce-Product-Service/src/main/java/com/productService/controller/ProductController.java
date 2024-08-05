package com.productService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productService.model.Product;
import com.productService.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	@PostMapping("/create")
	public ResponseEntity<Product> createProduct(@RequestBody Product product)
	{
		try {
			
			product =productService.createProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable String productId)
	{
		Product product=productService.getProductById(productId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
//		try {
//			Product product=productService.getProductById(productId);
//			if(product!=null)
//			{
//		return	ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return ResponseEntity.notFound().build();
	}
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable String productId,@RequestBody Product product)
	{
		try {
		product = productService.updateProduct(productId, product);
		return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED).body(product);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/list")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
	
	@DeleteMapping("/{productId}")
	public void deleteProductById(@PathVariable String productId)
	{
		productService.deleteProductById(productId);
	}


}
