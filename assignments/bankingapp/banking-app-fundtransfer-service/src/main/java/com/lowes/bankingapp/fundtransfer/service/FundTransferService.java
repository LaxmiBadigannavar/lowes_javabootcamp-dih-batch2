package com.lowes.bankingapp.fundtransfer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.lowes.bankingapp.fundtransfer.model.FundTransfer;
import com.lowes.bankingapp.fundtransfer.repository.FundTransferRepository;

@Service
public class FundTransferService {
	@Autowired
	FundTransferRepository fundRepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void create(FundTransfer fundtransfer) {
		fundtransfer.setStatus("PEDNING");
		fundRepo.save(fundtransfer);
		
		String msg = fundtransfer.getSourceAccountId() + "," + fundtransfer.getTargetAccountId() + "," + fundtransfer.getAmount()+","+fundtransfer.getDescription();
		
		kafkaTemplate.send("FUND_TRANSFER_CREATED", msg);
		
		//return order.getId();
	}
	 @KafkaListener(topics = "TRANSACTION_SUCESSFUL", groupId="fundtransfer-service")
	    public void listenOrderApproval(ConsumerRecord<?, ?> cr) throws Exception {
	        System.out.println("###################Fund Transfer Approved Received: " + cr.value());
	        
	    }
    
    @KafkaListener(topics = "TRANSACTION_REJECTED", groupId="fundtransfer-service")
    public void listenOrderRejection(ConsumerRecord<?, ?> cr) throws Exception {
        System.out.println("###################F Fund transfer Received: " + cr.value());
       
    }    
    	
}
