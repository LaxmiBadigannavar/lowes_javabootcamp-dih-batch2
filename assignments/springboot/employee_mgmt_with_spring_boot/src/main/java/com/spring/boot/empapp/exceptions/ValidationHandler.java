package com.spring.boot.empapp.exceptions;


import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.spring.boot.empapp.model.ResponseMessage;

@RestControllerAdvice 
public class ValidationHandler{

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
	@ExceptionHandler(NoSuchElementException.class)
	public Map<String,String> handleEmpNotFoundException(NoSuchElementException ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("Employee ID does not exist", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeException.class)
	public Map<String,String> handleEmpNotFoundException(EmployeeException ex){
		Map<String,String> errorMap = new HashMap<>();
		errorMap.put("ErrorMessage:", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ResponseEntity<ResponseMessage> handleDatabaseConnectionErrors(CannotCreateTransactionException ex) {
		ResponseMessage response = new ResponseMessage("Failure db", "Database Error with Message: " + ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}
	
	
}
