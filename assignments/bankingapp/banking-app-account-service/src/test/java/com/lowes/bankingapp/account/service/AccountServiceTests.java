package com.lowes.bankingapp.account.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lowes.bankingapp.account.exception.AccountException;
import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.repository.AccountRepository;

@SpringBootTest
public class AccountServiceTests {

	@Autowired
	AccountService accountService;

	@MockBean
	AccountRepository accountRepo;

	@BeforeAll
	public static void init() {
		// Logic to initialize test data goes here
		System.out.println("Test data initialization at class level..");
	}

	@AfterAll
	public static void tearDown() {
		// Logic to clean up test data goes here
		System.out.println("Test data clean up at class level..");
	}
	
	private static List<Account> accounts = new ArrayList<>();

	@BeforeEach
	public void setup() {
		// Initialize Test data
		Account account1 = new Account();
		account1.setId(1);
		account1.setName("Sam");
		account1.setType("Credit");
		account1.setStatus("active");
		account1.setBalance(30000);
		//accountService.createAccount(account1);
		accounts.add(account1);
		
		

		Account account2 = new Account();
		account2.setId(2);
		account2.setName("Ram");
		account2.setType("Savings");
		account2.setStatus("closed");
		account2.setBalance(30000);
		//accountService.createAccount(account1);
		accounts.add(account2);
		
	}

	@AfterEach
	public void cleanup() {
		accountService.clear();
//		products.clear();
	}


	@Test
	public void shouldUpdateAccoutForGivenAccountId() {
		Account account = new Account();
		account.setBalance(2000);
		account.setDescription("closed");

		try {
			accountService.updateAccount(2, account);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			assertNotNull(accountService.getAccount(2));
			assertEquals("Ram", accountService.getAccount(2).getName());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void shouldDeleteAccountWhenPassingValidAccountctId() {
		try {
			accountService.deleteAccount(2);
			assertNull(accountService.getAccount(2));
			assertEquals(2, accountService.getAccounts().size());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void shouldReturnProductForGivenAccountId() {
		Mockito.when(accountRepo.findById(1)).thenReturn(Optional.of(accounts.get(1)));
		
		
		try {
			assertNotNull(accountService.getAccount(2));
			assertEquals("2", accountService.getAccount(2).getId());
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
//	public void shouldReturnAllProductsWhenDontSpecifyProductId() {
//		Mockito.when(accountRepo.findAll()).thenReturn(accounts);
//		
//		try {
//			assertEquals(1, accountService.getAccounts().size());
//		} catch (AccountException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
