package com.lowes.bankingapp.account.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice 
public class AccountValidation {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map <String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
	
		Map <String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((error)->{
		errors.put(error.getField(),error.getDefaultMessage());
	});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AccountException.class)
	public Map<String,String> handleEmpNotFoundException(AccountException ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("ErrorMessage:", ex.getMessage());
		return errorMap;
	}
	
}
