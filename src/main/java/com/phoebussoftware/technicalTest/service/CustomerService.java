package com.phoebussoftware.technicalTest.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebussoftware.technicalTest.DTO.CustomerDTO;
import com.phoebussoftware.technicalTest.model.CustomerEntity;
import com.phoebussoftware.technicalTest.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public CustomerDTO postData(CustomerDTO customerDTO) {
		CustomerEntity customerEntity  = new CustomerEntity();
		BeanUtils.copyProperties(customerDTO, customerEntity);
		
		//Save to database
		customerEntity = customerRepository.save(customerEntity);
		
		//Send customerDTO back to controller
		BeanUtils.copyProperties(customerEntity, customerDTO);
		
		return customerDTO;
	}

}
