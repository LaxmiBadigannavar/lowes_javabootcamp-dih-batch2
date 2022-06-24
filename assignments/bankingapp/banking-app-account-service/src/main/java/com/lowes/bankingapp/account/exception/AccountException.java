package com.lowes.bankingapp.account.exception;

public class AccountException extends Exception{
	public AccountException(String message) {
		super();
		this.message = message;
	}

	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
