package com.ecommerce.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.userservice.model.UserServiceModel;

@Repository
public interface UserRepository extends JpaRepository<UserServiceModel, String>{
	// login
	@Query("select user from UserServiceModel user where user.email=:email and user.password=:password")
	public UserServiceModel login(@Param("email") String email,@Param("password") String password);
	
	// check already user exit or not
	@Query("select user.email from UserServiceModel user where user.email=:email")
	public String exitEmail(@Param("email") String email);

}
