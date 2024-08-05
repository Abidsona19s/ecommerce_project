package com.productService.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Id not found");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	
	

}
