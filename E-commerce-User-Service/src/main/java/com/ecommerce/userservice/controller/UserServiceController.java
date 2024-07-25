package com.ecommerce.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.userservice.model.UserServiceModel;
import com.ecommerce.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserServiceController {
	
	@Autowired
	UserService userService;
	
	// Register new user
	
	@PostMapping("/register")
	public ResponseEntity<UserServiceModel> saveUser(@RequestBody UserServiceModel userServiceModel)
	{
		UserServiceModel model=null;
		try
		{
			String exitsEmail=userService.exitsByEmail(userServiceModel.getEmail());
			if(exitsEmail!=null)
			{
				System.out.println("found ");
				return ResponseEntity.status(HttpStatus.FOUND).build();
				
			}
			else {
				 model=userService.registerNewUser(userServiceModel);
				System.out.println(model);
				return ResponseEntity.status(HttpStatus.CREATED).body(model);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
	}
	
	// find user by id
	@GetMapping("/{id}")
	public ResponseEntity<UserServiceModel> getById(@PathVariable String id)
	{
		UserServiceModel model= userService.getById(id);
		try {
		if(model!=null)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(model);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	// update exiting user details
	
	@PutMapping("/{id}")
	public UserServiceModel updateUser(@PathVariable String id, @RequestBody UserServiceModel userServiceModel)
	{
		return userService.updateUser(id,userServiceModel);
	}
	
//	// login based on the email and password
	@GetMapping("/login")
	public ResponseEntity<UserServiceModel> login(@RequestParam String email,String password)
	{
		UserServiceModel model=userService.login(email, password);
		try
		{
			if(model.getEmail().equals(email) && model.getPassword().equals(password))
			{
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(model);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		
	}

}
