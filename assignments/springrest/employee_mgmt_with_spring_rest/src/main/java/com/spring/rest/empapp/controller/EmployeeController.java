package com.spring.rest.empapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.spring.rest.empapp.model.Employee;
import com.spring.rest.empapp.model.ResponseMessage;
import com.spring.rest.empapp.service.EmployeeService;


@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class); 

	@Autowired
	EmployeeService empService;

	// Create Account
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseMessage> create(@RequestBody Employee employee) throws URISyntaxException  {
						
		// Logic to add account
		Employee employeeCreated = empService.createEmployee(employee);		
		
		// Build newly created Account resource URI
		// http://localhost:8080/spring-rest-labs/accounts/{id}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeeCreated.getEmpId()).toUri();
		ResponseMessage response = new ResponseMessage("Success", "Employee added Successfully");
		return ResponseEntity.created(location).body(response);
	}
	
	// Getall Employees
		@GetMapping
		public List<Employee> getAll(){
			return empService.getAll();
		}
		
		// Get Employee
		@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public Employee get(@PathVariable int id) {
			return empService.get(id);
		}
		
		// Update Employee
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

}
