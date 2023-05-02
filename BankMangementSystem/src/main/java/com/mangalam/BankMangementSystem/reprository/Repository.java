package com.mangalam.BankMangementSystem.reprository;

import java.text.AttributedString;

import org.springframework.data.repository.CrudRepository;

import com.mangalam.BankMangementSystem.model.CustomerLogin;

public interface Repository extends CrudRepository<CustomerLogin, Integer>{
	
	CustomerLogin findByEmail(String email); 

}
