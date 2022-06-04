package com.empapp.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;



public class JavaConfigBasedDepedencyInjectionEx01 {

	public static void main(String[] args) {
		// Assemble the objects
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(GreetingsConfig.class);

		Greetings obj = (Greetings) context.getBean("greetings");
		
		obj.getMessage();
		
		context.registerShutdownHook();		

	}
}
