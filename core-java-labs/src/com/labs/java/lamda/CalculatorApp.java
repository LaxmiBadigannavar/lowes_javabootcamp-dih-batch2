package com.labs.java.lamda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class CalculatorApp {

	public static void main(String[] args) {
		/*
		 * ICalculator add=(a,b)-> a +b; ICalculator substract=(a,b)-> a -b; ICalculator
		 * multiply=(a,b)-> a +b; ICalculator divide=(a,b)-> a +b; ICalculator
		 * mod=(a,b)-> a % b;
		 */
		BiFunction<Integer, Integer, Integer>add=(a,b)->{
			System.out.println(a+b);
			return (a+b);
			};
		
		//BiFunction<Integer, Integer, Integer>substract=(a,b)->a-b;
		
							
		//BiFunction<Integer, Integer, Integer>substract = (a,b)->a-b;
		
		//Consumer<String> consumer =(msg)->System.out.println(msg);
	
		
		//System.out.println("40+20="+(40, 20, add));
		/*System.out.println("40+20="+doCalcualte(40, 20, substract));
		System.out.println("40+20="+doCalcualte(40, 20, multiply));
		System.out.println("40+20="+doCalcualte(40, 20, mod));
*/
	}


 	private static Object doCalcualte(int a,int b,ICalculator operation) {
 		return operation.calculate(a,b);
 	}	
 	public interface ICalculator{
		public Object calculate(int a,int b);
	}
 	} 
 