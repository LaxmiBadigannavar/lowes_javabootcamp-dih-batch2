package com.labs.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeetingsController {
	//String msg =" Hello Spring Boot";
	
	Logger logger = LoggerFactory.getLogger(GeetingsController.class);
	@GetMapping("/greetings")
	public String greetings() {
		
		logger.trace("TRACE LOG");
		logger.debug("DEBUG LOG");
		logger.info("DEBUG LOG");
		logger.warn("INFO LOG");
		logger.error("ERROR LOG");
		return "Welcome to Spring Training 123";
		
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello....";
	}
}
