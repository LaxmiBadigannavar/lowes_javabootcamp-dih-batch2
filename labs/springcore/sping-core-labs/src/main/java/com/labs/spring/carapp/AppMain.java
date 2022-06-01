package com.labs.spring.carapp;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new  AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println("no of beans:"+ctx.getBeanDefinitionCount());
		
		for(String BeanName:ctx.getBeanDefinitionNames()) {
			System.out.println(BeanName);
			
			if(Arrays.asList("bmw","nexon").contains(BeanName)) {
				Car car = ctx.getBean(Car.class);
				System.out.println(car.getModel()+" "+car.getColor()+" "+ car.getManufacture()+" "+car.getColor());
				
			}
		}
		
		Car bmw = ctx.getBean("bmw",Car.class);
		System.out.println(bmw.getModel()+" "+bmw.getColor()+" "+ bmw.getManufacture()+" "+bmw.getColor());
		
		ctx.registerShutdownHook();
	}

}
