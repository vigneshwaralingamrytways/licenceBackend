package com.rytways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rytways.model.CustomerMasterEntity;
import com.rytways.service.CustomerMasterService;

@RestController
@RequestMapping("/customers")
public class CustomerMasterController {

	@Autowired
	private CustomerMasterService service;

	@PostMapping("/createCustomer")
	public CustomerMasterEntity createCustomer(@RequestBody CustomerMasterEntity customer) {
		return service.createCustomer(customer);
	}

	@GetMapping("/getAllCustomers")
	public List<CustomerMasterEntity> getAllCustomers() {
		return service.getAllCustomers();
	}

	@PostMapping("/update/{id}")
	public CustomerMasterEntity updateCustomer(@PathVariable Long id, @RequestBody CustomerMasterEntity customer) {
		return service.updateCustomer(id, customer);
	}

	@PostMapping("/approve/{id}")
	public CustomerMasterEntity approveCust(@PathVariable Long id, @RequestBody CustomerMasterEntity customer) {
		return service.approve(id, customer);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		service.deleteCustomer(id);
		return "Customer deleted successfully";
	}

}
