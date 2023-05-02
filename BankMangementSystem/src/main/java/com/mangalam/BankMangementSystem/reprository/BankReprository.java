package com.mangalam.BankMangementSystem.reprository;

import org.springframework.data.repository.CrudRepository;

import com.mangalam.BankMangementSystem.model.Customer;

public interface BankReprository extends CrudRepository<Customer, Integer>{
	
	Customer findByName(String name);

}
