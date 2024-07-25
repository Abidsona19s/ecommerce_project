package com.ecommerce.userservice.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.userservice.model.UserServiceModel;
import com.ecommerce.userservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	// Register new user
	
	public UserServiceModel registerNewUser(UserServiceModel userServiceModel)
	{
		userServiceModel.setId(UUID.randomUUID().toString());
		userServiceModel.setCreatedAt(LocalDateTime.now());
		return userRepository.save(userServiceModel);
	}
	
	// find user by id
	
	public UserServiceModel getById(String id)
	{
		return userRepository.findById(id).orElse(null);
	}
	
	// update exiting user details
	
	public UserServiceModel updateUser(String id,UserServiceModel userServiceModel)
	{
		UserServiceModel model=userRepository.findById(id).orElse(null);
		if(model!=null)
		{
			model.setUserName(userServiceModel.getUserName());
			model.setEmail(userServiceModel.getEmail());
		
		return userRepository.save(model);
	}
		return null;
	}
	
	// login based on the email and password
	
	public UserServiceModel login(String email,String password)
	{
		return userRepository.login(email, password);
	}
	
	//  email exit or not
	
	public String  exitsByEmail(String email)
	{
		
		//boolean flag=false;
		
		String exitsEmail= userRepository.exitEmail(email);
		
		
//		if(email.equals(userServiceModel.getEmail())) {
//			
//			return flag=true;
//			
//		}
//		else {
//			return flag;
//		}
		return exitsEmail;
	}

	
	
	

}
