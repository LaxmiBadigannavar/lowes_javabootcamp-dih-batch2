package com.lowes.bankingapp.transactions.model;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue
	private int id;
	private int accountId;
	
	@NotEmpty(message= "type should not be empty")
	private String type;
	@NotEmpty(message= "trasanction type should be mentioned")
	private String description;
	@Min(value = 1000, message = "minimum amount should be 1000")
	private double amount;
//	private String status;
//	
//		public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
		@UpdateTimestamp
	private LocalDateTime transactionTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public LocalDateTime getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(LocalDateTime transactionTime) {
		this.transactionTime = transactionTime;
	}
	
}
