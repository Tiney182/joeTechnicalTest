package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Integer customerId) {
		return ResponseEntity.ok(CustomerDTO.builder().build());
	}

	@GetMapping("/account/{customerId}")
	public ResponseEntity<List<AccountDTO>> getAccountsByCustomerId(@PathVariable Integer customerId) {

		List<AccountDTO> accountDTOS = List.of(AccountDTO.builder().build());
		return new ResponseEntity<>(accountDTOS, HttpStatus.OK);
	}

	/*
	@PostMapping(path = "/customer")
	public CustomerEntity newCustomer(@RequestBody CustomerEntity customerEntity) {
		customerEntity = customerRepository.save(customerEntity);
		return customerEntity;

	}
	Done for testing. Now separating layers
	*/
	
	@PostMapping(path = "/customer")
	public CustomerDTO newCustomer(@RequestBody CustomerDTO customerDTO) {
		customerDTO = customerService.postData(customerDTO);		
		return customerDTO;
	}
}
