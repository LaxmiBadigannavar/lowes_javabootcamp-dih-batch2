package com.lowes.bankingapp.account.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table
public class Account {
	@Id
	@GeneratedValue
	private int id;
	@NotEmpty
	@Size(min = 2,message = "Name should be of atleast of 2 characters")
	private String name;
	@NotEmpty
	private String type;
	@NotEmpty
	private String status;
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Min(value=1000, message="Minimum balance should be 1000")
	@Max(value= 1000000, message = "Maximum age is 1000000")
	private double balance;
	@UpdateTimestamp
	private LocalDate openDate;
	
	public LocalDate getOpenDate() {
		return openDate;
	}
	public void setOpenDate(LocalDate openDate) {
		this.openDate = openDate;
	}
	public String getName() {
		return name;
	}
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

}
