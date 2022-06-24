package com.lowes.bankingapp.account.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowes.bankingapp.account.exception.AccountException;
import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	 private static Logger log = LoggerFactory.getLogger(AccountController.class);
	   
	   @Autowired
	   AccountService accountService;
	   
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Object> delete(@PathVariable("id") int id)throws AccountException  { 
		   accountService.deleteAccount(id);
		   return new ResponseEntity<>("Account is deleted successsfully", HttpStatus.OK);
	   }
	   
	   @PutMapping("/{id}")
	   public ResponseEntity<Object> updateAccount(@PathVariable("id") int id, @RequestBody Account account) throws AccountException{ 
		   	accountService.updateAccount(id, account);
		   	return new ResponseEntity<>("Account is updated successsfully", HttpStatus.OK);
	   }
	   
	   @PostMapping
	   public ResponseEntity<String> createAccount(@RequestBody @Valid Account account)  {
		   accountService.createAccount(account);
		   return new ResponseEntity<>("Account is created successfully", HttpStatus.CREATED);
	   }
	   
	   @GetMapping
	   public ResponseEntity<Object> getAccounts() throws AccountException {
		  log.info("Received request to list Accounts...");
  		  return new ResponseEntity<>(accountService.getAccounts(), HttpStatus.OK);
	   }
	   @GetMapping("/{id}")
	   public ResponseEntity<Object> getAccount(@PathVariable("id") int id) throws AccountException {
		  log.info("Received requested Account...");
  		  return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
	   }
}
