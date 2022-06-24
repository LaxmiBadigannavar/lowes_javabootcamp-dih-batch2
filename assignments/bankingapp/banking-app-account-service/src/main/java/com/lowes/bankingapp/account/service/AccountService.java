package com.lowes.bankingapp.account.service;

import java.util.Collection;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.account.exception.AccountException;
import com.lowes.bankingapp.account.model.Account;
import com.lowes.bankingapp.account.repository.AccountRepository;



@Service
public class AccountService {

	  @Autowired
	    AccountRepository accountRepo;
	  @Autowired
		KafkaTemplate<String, String> kafkaTemplate;	

	    public Collection<Account> getAccounts() throws AccountException{
	    	if(accountRepo.findAll()==null || accountRepo.findAll().isEmpty()) {
	    		throw new AccountException("No Account present");
	    	}
	    	else {
	    				return accountRepo.findAll();
	    	}
	    }

	    public String createAccount(Account account) {
//	        if(account.getId() == null || account.getId().isEmpty()) {
//	            throw new RuntimeException("Account Id mandatory");
//	        }   
	        accountRepo.save(account);
	        return "Account Created";
	    }

	    public void updateAccount(int id, Account account) throws AccountException{
	    	if(accountRepo.findById(id).isEmpty()) {
	    		System.out.println("id not there in present"+accountRepo.findById(id));
			        throw new AccountException("Account not present");
		     }else {   
		    	 System.out.println("Account not null::"+account);
		    	// System.out.println("id not there in present"+accountRepo.findById(id));
		    	 System.out.println("Id is:"+id);
	      	    	 accountRepo.save(account);
	      	    	
		     }
	    }

	    public void deleteAccount(int id) throws AccountException{
	    	if(accountRepo.findById(id)==null || accountRepo.findById(id).isEmpty()) {
	    		throw new AccountException("Account Id not present");
	    	}else {
	    		accountRepo.deleteById(id);
	    	}
	    }

	    public Account getAccount(int id) throws AccountException{
	    	if(accountRepo.findById(id)==null || accountRepo.findById(id).isEmpty()) {
	    		throw new AccountException("Account Id not present");
	    	}else {
	    		Optional<Account> account = accountRepo.findById(id);
	    		return account.isPresent() ? account.get() : null;
	    	}
	    }

	    public void clear() {
	    	accountRepo.deleteAll();    	
	    }
	    
	    @KafkaListener(topics = "TRANSACTION_SUBMITTED", groupId="account-service")
	    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
	        System.out.println("###################Order Approved Received: " + cr.value());
	        String msg = (String) cr.value();
	        String[] tokens = msg.split(",");
	        String sourceId = tokens[0];
	        String targetId = tokens[1];
	        String amount = tokens[2];
	        String description = tokens[3];
	        String debitTran = tokens[4];
	        String creditTran = tokens[5];
	        double amountToTransfer = Double.valueOf(amount);
	        
	        Account account = accountRepo.findById(Integer.valueOf(sourceId)).get();
	        Account account1 = accountRepo.findById(Integer.valueOf(targetId)).get();
	        double availableBalance = account.getBalance();
	        if(availableBalance >= amountToTransfer) {
	        	account.setBalance(availableBalance-amountToTransfer);
	        	account.setDescription(description);
	        	account.setStatus("closed");
	        	System.out.println("TRANSACTION SUCESSFUL :: " + sourceId);
	        	
	        	//to do credit transaction
	        	account1.setBalance(account1.getBalance()+amountToTransfer);
	        	account1.setDescription(description);
	        	account1.setStatus("closed");
	        	String details = sourceId+","+targetId+","+debitTran+","+creditTran;
	        	System.out.println("Details "+details);
	        	accountRepo.save(account);
	        	accountRepo.save(account1);
	        	
	        	
	        	kafkaTemplate.send("TRANSACTION_SUCESSFUL", details);
	        }
	        else {
	        	String details = sourceId+","+targetId+","+debitTran+","+creditTran;
	        	kafkaTemplate.send("TRANSACTION_REJECTED",details);
	        }
	        
	        
	    }
	
}
