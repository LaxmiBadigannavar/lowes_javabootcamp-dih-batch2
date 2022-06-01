package com.labs.spring.carapp;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

public class ApplicationConfig {
	@Bean(autowire = Autowire.BY_TYPE, initMethod = "init", destroyMethod = "destroy")
	@Lazy(value = true)
	
	/*
	 * public Car bmw() { return new Car("xt","BMW","white",Petrol()); }
	 */
	public Car bmw() {
		Car bmw = new Car() ;
		bmw.setModel("XX");
		bmw.setColor("Red");
		bmw.setManufacture("yy");
		return bmw;
		}
	@Bean
	public Engine 	Petrol() {
		return new Engine("Petrol",2000);
	}
	@Bean
	public Engine 	Diesel() {
		return new Engine("Diesel",4000);
	}
	@Bean(autowireCandidate =  false)
	public Engine 	Electric() {
		return new Engine("Electric",6000);
	}

	public void init() {
		System.out.println("Initialise Method");
	}
	public void destroy() {
		System.out.println("Destroy Method");
	}
	
}
