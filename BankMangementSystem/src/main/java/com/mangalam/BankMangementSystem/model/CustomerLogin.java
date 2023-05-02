package com.mangalam.BankMangementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	String email;
	String password;
	
	public CustomerLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerLogin(String email, String password){
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerLogin [email=" + email + ", password=" + password + "]";
	}
	
	

}
