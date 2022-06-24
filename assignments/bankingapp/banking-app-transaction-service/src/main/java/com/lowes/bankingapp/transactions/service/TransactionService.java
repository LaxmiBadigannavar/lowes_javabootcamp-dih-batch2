package com.lowes.bankingapp.transactions.service;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.lowes.bankingapp.transactions.model.Transaction;
import com.lowes.bankingapp.transactions.repository.TransactionRepository; 

@Service
public class TransactionService {
	@Autowired
	TransactionRepository tranRepository;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;	
	
	
	/**
	 * @param customer
	 * @return
	 */
	public Integer add(Transaction transaction) {
		tranRepository.save(transaction);
		return transaction.getId();
	}

	public void update(Transaction transaction) {
		tranRepository.save(transaction);
	}

	public Transaction get(Integer id) {
		Optional<Transaction> trans = tranRepository.findById(id); 
		return  trans.isPresent() ? trans.get() : null;
	}

	public void delete(Integer id) {
		tranRepository.deleteById(id);
	}

	public List<Transaction> list() {
		return tranRepository.findAll();
	}
	
	public void deleteAll()
	{
		tranRepository.deleteAll();
	}
	
    @KafkaListener(topics = "FUND_TRANSFER_CREATED", groupId="transaction-service")
    public void listentToFund(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Transaction Created: " + cr.value());

        String msg = (String) cr.value();
        String[] tokens = msg.split(",");
        String sourceId = tokens[0];
        String targetId = tokens[1];
        String amount = tokens[2];
        String description = tokens[3];
        double amountToTransfer = Double.valueOf(amount);
        
        //Logic to add to debit acc table
       Transaction transaction = new Transaction();
        transaction.setAccountId(Integer.parseInt(sourceId));
        transaction .setAmount(amountToTransfer);
        transaction.setType("Debit");
        transaction.setDescription(description);
       // transaction .setStatus("Pending");
        tranRepository.save(transaction);      
        int transactionIddeb = transaction.getId();
         System.out.println("Adding details of debit acc is done"+transactionIddeb);
          
        //logic to add credit acc details
         Transaction transaction1 = new Transaction();
          System.out.println("Adding details of creadit acc is started");
        transaction1.setAccountId(Integer.parseInt(targetId));
        transaction1 .setAmount(amountToTransfer);
        transaction1.setType("Credit");
        transaction1.setDescription(description);
       // transaction1.setStatus("Pending");
        tranRepository.save(transaction1);
        int transactionIdcre = transaction.getId();
        System.out.println("Adding details of creadit acc is done"+transactionIdcre);
        
        // Logic to check credit limit        
//        Transaction transaction = tranRepository.findById(Integer.valueOf(sourceId)).get();
//        double avilableBalance = transaction.getAmount();
//        if(availableCreditLimit >= dPrice) {
//        	transaction.setCreditLimit(availableras
        	String detailstoAcc = sourceId+","+targetId+","+amount+","+description+","+transactionIddeb+","+transactionIdcre;
        	kafkaTemplate.send("TRANSACTION_SUBMITTED", detailstoAcc);
                  
    	}	
    @KafkaListener(topics = "TRANSACTION_SUCESSFUL", groupId="transaction-service")
    public void listenTransactionApproval(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Transaction Approved Received: " + cr.value());
        //logic to update transaction table
        String details = (String) cr.value();
        String[] tokens = details.split(",");
        //String sourceId = tokens[0];
        //String targetId = tokens[1];
        String debitTran = tokens[2];
        String creditTran = tokens[3];
        Transaction transaction= tranRepository.getById(Integer.getInteger(debitTran));
        Transaction transaction2= tranRepository.getById(Integer.getInteger(creditTran));
       //transaction.setStatus("TRANSACTION_SUCESSFUL");
       //transaction2.setStatus("TRANSACTION_SUCESSFUL");
       tranRepository.save(transaction);
       tranRepository.save(transaction2);
       kafkaTemplate.send("TRANSACTION_SUCESSFUL", "TRANSACTION_SUCESSFUL");
       
    }
    
    @KafkaListener(topics = "TRANSACTION_REJECTED", groupId="transaction-service")
    public void listenTransactionRejection(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################Transaction Rejected Received: " + cr.value());
        String details = (String) cr.value();
        String[] tokens = details.split(",");
        //String sourceId = tokens[0];
        //String targetId = tokens[1]; 
        String debitTran = tokens[2];
        String creditTran = tokens[3];
        Transaction transaction= tranRepository.getById(Integer.getInteger(debitTran));
        Transaction transaction2= tranRepository.getById(Integer.getInteger(creditTran));
       //transaction.setStatus("TRANSACTION_REJECTED");
       //transaction2.setStatus("TRANSACTION_REJECTED");
       tranRepository.save(transaction);
       tranRepository.save(transaction2);
       kafkaTemplate.send("TRANSACTION_REJECTED", "TRANSACTION_REJECTED");
    }    
    
   }	
