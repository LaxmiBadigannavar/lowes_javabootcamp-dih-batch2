package com.labs.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldSpring {
	public static void main(String[] args) {
		/*
		 * Greetings greeting = new Greetings();
		 * System.out.println(greeting.getMessage());
		 * greeting.setMessage("How are you?");
		 * System.out.println(greeting.getMessage());
		 */
		
		//step1:
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml");
		System.out.println(ctx);
		
		System.out.println("No of beans: "+ctx.getBeanDefinitionCount());
		
		Greetings greetings = ctx.getBean("greetings", Greetings.class);
		System.out.println(greetings.getMessage());
		
		Greetings greetings1 = ctx.getBean("greetings1", Greetings.class);
		System.out.println(greetings1.getMessage());
		
		Greetings greetings2 = ctx.getBean("greetings2", Greetings.class);
		System.out.println(greetings2.getMessage());
		
	
		
	}
}