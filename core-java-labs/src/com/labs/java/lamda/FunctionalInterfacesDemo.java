package com.labs.java.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfacesDemo {

	public static void main(String[] args) {
		
		Consumer<String> consumer=(msg)->System.out.println(msg);
		consumer.accept("Hello Consumer");
		
		BiConsumer<String,String> biconsumer=(msg1,msg2)->System.out.println(msg1+" msg2");
		biconsumer.accept("Hello", "Lamda!!!");
		
		Supplier<List> suplier = ()->Arrays.asList("Java","Spring","Hibernate");
		System.out.println(suplier.get());
		
		Function<Integer,String> function=(a)->{if (a%2 ==0)return "even";else return "odd";};
		System.out.println(function.apply(10));
		
		UnaryOperator<Integer> unary = (a)->a*2;
		System.out.println(unary.apply(10));
		
		BinaryOperator<Integer> binary=(a,b)->(a+b)*2;
		System.out.println(binary.apply(10, 20));
		
		//Predicate -> take arguments and return value
				Predicate<Integer> pred = (age) -> age > 20;
				System.out.println(pred.test(30));
	}

}
