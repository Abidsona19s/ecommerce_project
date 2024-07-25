package com.ecommerce.userservice.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class UserServiceModel {
	@Id
	private String id;
	private String userName;
	
	private String password;
	private String email;
	private LocalDateTime createdAt;
	public UserServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserServiceModel(String id, String userName, String password, String email, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "UserServiceModel [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}
