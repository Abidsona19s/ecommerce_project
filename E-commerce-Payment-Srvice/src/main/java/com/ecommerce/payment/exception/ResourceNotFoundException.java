package com.ecommerce.payment.exception;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException()
	{
		super("invalid payment id");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}

}
