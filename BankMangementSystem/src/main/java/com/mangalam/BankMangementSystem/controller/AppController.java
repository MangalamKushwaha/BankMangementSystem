package com.mangalam.BankMangementSystem.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mangalam.BankMangementSystem.model.Customer;
import com.mangalam.BankMangementSystem.model.CustomerLogin;
import com.mangalam.BankMangementSystem.reprository.BankReprository;
import com.mangalam.BankMangementSystem.reprository.Repository;

@Controller
public class AppController {
	
	@Autowired
	Repository customerRepository;
	@Autowired
	BankReprository bankReprository;
	
	@PostMapping("/register")
	public String registerPage(@RequestParam String email, @RequestParam String password, Model model) {
		customerRepository.save(new CustomerLogin(email, password));
		model.addAttribute("Message", "registered");
		model.addAttribute("message", email);
		return "success";
	}
	
	@PostMapping("/login")
	public String loginPage(@RequestParam String email, @RequestParam String password, Model model) {
		CustomerLogin customerLogin = customerRepository.findByEmail(email);
		if(customerLogin != null && customerLogin.getPassword().equals(password)) {
			model.addAttribute("Message", email);
			return "welcome";
		}
		return "error";
	}
	
	@PostMapping("/add")
	public String addBankDetails(@RequestParam String name, @RequestParam String bankName, @RequestParam Integer balance, Model model) {
		bankReprository.save(new Customer(name, bankName, balance));
		model.addAttribute("Message", "Customer Bank Details Added Successfully");
		return "success";
		
	}
	
	@PostMapping("/update")
	public String updateBankDetails(@RequestParam String name, @RequestParam String bankName, @RequestParam Integer balance, Model model) {
		Customer customer = bankReprository.findByName(name);
		if(customer != null) {
			customer.setBankName(bankName);
			customer.setBalance(balance);
			bankReprository.save(customer);
			model.addAttribute("Message","Customer Bank Details Updated Successfully");
			return "success";
		}
		return "error";
		
	}
	
	@PostMapping("/delete")
	public String deleteBankDetails(@RequestParam String name, Model model) {
		Customer customer = bankReprository.findByName(name);
		if(customer != null) {
			bankReprository.delete(customer);
			model.addAttribute("Message", "Customer Bank Details Deleted Succesfully");
			return "success";
		}
		return "error";
	}
	
	@GetMapping("/fetch")
	public String fetchBankDetails(Model model) {
		ArrayList<Customer> customer = new ArrayList<>();
		bankReprository.findAll().forEach((customers)->customer.add(customers));
		model.addAttribute("emp", customer);
		return "fetchCustomer";
	}
	
	@PostMapping("/deposit")
	public String depositAmount(@RequestParam String name, @RequestParam Integer amount, Model model) {
		Customer customer = bankReprository.findByName(name);
		if(customer != null) {
			customer.setBalance(amount + customer.getBalance());
			bankReprository.save(customer);
			model.addAttribute("Message", "Amount deposited succesfully");
			return "success";
		}
		return "error";
	}
	
	@PostMapping("/withdraw")
	public String withdrawAmount(@RequestParam String name, @RequestParam Integer amount, Model model) {
		Customer customer = bankReprository.findByName(name);
		if(customer != null && customer.getBalance() >= amount) {
			customer.setBalance(customer.getBalance() - amount);
			bankReprository.save(customer);
			model.addAttribute("Message", "Amount withdrawn succesfully");
			return "success";
		}
		return "error";
	}
}
