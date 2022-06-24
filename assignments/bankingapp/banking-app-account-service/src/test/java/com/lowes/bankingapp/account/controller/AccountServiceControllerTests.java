package com.lowes.bankingapp.account.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.lowes.bankingapp.account.exception.AccountException;
import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.service.AccountService;

// API Test / Integration test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountServiceControllerTests {

    @Autowired
    TestRestTemplate restTemp;

//  @Autowired    
    @MockBean
    AccountService accountService;
    
    @UpdateTimestamp
	private LocalDate openDate;

    private static List<Account> accounts = new ArrayList<>();

    @BeforeEach
    public void setup() {
        // Initialize Test data

        
        Account account1 = new Account();
		account1.setId(1);
		account1.setName("Sam");
		account1.setType("Credit");
		account1.setStatus("active");
		account1.setOpenDate(openDate);
		account1.setBalance(30000);
		//accountService.createAccount(account1);
		accounts.add(account1);
        

		Account account2 = new Account();
		account2.setId(2);
		account2.setName("Ram");
		account2.setType("Savings");
		account2.setStatus("closed");
		account2.setOpenDate(openDate);
		account2.setBalance(30000);
		//accountService.createAccount(account1);
		accounts.add(account2);
    }

    @AfterEach
    public void cleanup() {
//        productService.clear();
    	accounts.clear();
    }

    @Test
    public void shouldCreateAccount() throws URISyntaxException
    {
        // POST /products

    
        Mockito.when(accountService.createAccount(new Account())).thenReturn("Account is created successfully");

        String reqBody = "{\"id\":\"1\",\"name\":\"Geetha\",\"type\":\"Savings\",\"status\":\"active\",\"balance\":\"20000\"}";


        // Step 1: Create Request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/accounts"));

        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response

        ResponseEntity<String> response = restTemp.exchange(request, String.class);

        System.out.println("Response: " + response.getBody());

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo("Account is created successfully");
    }


    @Test
    public void shouldReturnAllAccounts() {

        try {
			Mockito.when(accountService.getAccounts()).thenReturn(accounts);
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // REST Template
        // Step 1: Create Request
        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response
        ResponseEntity<Object> response = restTemp.getForEntity("/accounts", Object.class);

        List<Account> products = (List) response.getBody();

        System.out.println("Response: " + products);

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);
      
    }
}
