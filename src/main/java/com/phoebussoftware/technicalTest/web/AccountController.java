package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import com.phoebussoftware.technicalTest.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired 
	AccountService accountService;

	@GetMapping("/{accountId}")
	public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer accountId) {

		return ResponseEntity.ok(AccountDTO.builder().build());
	}

	/* Testing complete. Now separating layers
	@PostMapping(path = "/account")
	public AccountEntity newAccount(@RequestBody AccountEntity accountEntity) {
		accountEntity = accountRepository.save(accountEntity);
		return accountEntity;

	}
	*/
	@PostMapping(path = "/account")
	public AccountDTO newAccount(@RequestBody AccountDTO accountDTO) {
		accountDTO = accountService.postData(accountDTO);
		return accountDTO;

	}
}
