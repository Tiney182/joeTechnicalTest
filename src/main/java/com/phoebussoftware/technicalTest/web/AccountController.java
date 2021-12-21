package com.phoebussoftware.technicalTest.web;

import com.phoebussoftware.technicalTest.DTO.AccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDTO> getAccountById(@PathVariable Integer accountId) {

    return ResponseEntity.ok(AccountDTO.builder().build());
  }
}
