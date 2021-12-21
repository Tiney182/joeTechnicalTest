package com.phoebussoftware.technicalTest.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.model.AccountEntity;
import com.phoebussoftware.technicalTest.repository.AccountRepository;

@Service
public class AccountService implements AccountServiceInterface{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public AccountDTO postData(AccountDTO accountDTO) {
		AccountEntity accountEntity = new AccountEntity(); //Detached object
		BeanUtils.copyProperties(accountDTO, accountEntity);
		
		//Save to database
		accountEntity = accountRepository.save(accountEntity);
		
		//Send accountDTO back to controller
		BeanUtils.copyProperties(accountEntity, accountDTO);
		return accountDTO;
	}

}
