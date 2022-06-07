package com.labs.spring.rest;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class GreetingsController {

	//http://localhost:8080/spring-rest-labs/greetings
	@RequestMapping(path = "/greetings", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
	public String getString(){
		return "Hello Spring REST";
	}
	
}
