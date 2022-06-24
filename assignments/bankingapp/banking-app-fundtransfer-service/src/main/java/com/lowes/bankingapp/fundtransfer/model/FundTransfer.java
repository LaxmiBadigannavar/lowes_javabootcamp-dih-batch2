package com.lowes.bankingapp.fundtransfer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class FundTransfer {
	@Id
	@GeneratedValue
	private int fundTransId;
	private int sourceAccountId;
	private int targetAccountId;
	private double amount;
	private String description;
	private String status;
	public int getTransId() {
		return fundTransId;
	}
	public void setfundTransId(int fundTransId) {
		this.fundTransId = fundTransId;
	}
	public int getSourceAccountId() {
		return sourceAccountId;
	}
	public void setSourceAccountId(int sourceAccountId) {
		this.sourceAccountId = sourceAccountId;
	}
	public int getTargetAccountId() {
		return targetAccountId;
	}
	public void setTargetAccountId(int targetAccountId) {
		this.targetAccountId = targetAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
