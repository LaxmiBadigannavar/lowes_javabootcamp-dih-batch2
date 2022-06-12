package com.spring.boot.empapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boot.empapp.exceptions.EmployeeException;
import com.spring.boot.empapp.model.Employee;
import com.spring.boot.empapp.model.ResponseMessage;
import com.spring.boot.empapp.service.EmployeeService;



@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class); 

	@Autowired
	EmployeeService empService;

	// add Employee
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseMessage> create(@RequestBody @Valid Employee employee, BindingResult errors) throws URISyntaxException, EmployeeException {
		
		if(errors.hasErrors()) {
			for(ObjectError error:errors.getAllErrors()) {
				logger.error("Validation Error: {} - {} ", error.getObjectName(), error.getDefaultMessage());
			}
			throw new EmployeeException("Validation Errors");
		}
		
		// Logic to add account
		Employee empCreated = empService.createEmployee(employee);		
		
		// Build newly created Account resource URI
		// http://localhost:8080/spring-rest-labs/accounts/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empCreated.getEmpId()).toUri();
		ResponseMessage response = new ResponseMessage("Success", "Employee added Successfully");
		return ResponseEntity.created(location).body(response);
	}

	// List Employee
	@GetMapping
	public List<Employee> getAll() throws EmployeeException {
		return empService.getAll();
	}

	// Get Employee
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee get(@PathVariable int id) {
		return empService.get(id);
	}

	// Update Account
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable int id, @RequestBody Employee employee) {
		employee.setEmpId(id);
		Employee updatedEmp = empService.update(id, employee);
		return ResponseEntity.ok().body("Employee updated successfully");
	}

	// Delete Account
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		empService.delete(id);
		return ResponseEntity.ok().body("Employee deleted successfully");
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ResponseMessage>  handleErrors(EmployeeException ex) {
		ResponseMessage response = new ResponseMessage("Failure", ex.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}	

}
