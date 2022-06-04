package com.empapp.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class GreetingsConfig {
	@Bean
	public Greetings greetings() {
		return new Greetings("Welcome to Spring Framework Training :) - Java based configuration example");
	}
}