package com.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productService.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
