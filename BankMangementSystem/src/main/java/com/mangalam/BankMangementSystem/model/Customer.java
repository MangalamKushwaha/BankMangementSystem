package com.mangalam.BankMangementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	public String name;
	public String bankName;
	public Integer balance;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String bankName, Integer balance){
		this.name = name;
		this.bankName = bankName;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", bankName=" + bankName + ", balance=" + balance + "]";
	}
	
	

}
