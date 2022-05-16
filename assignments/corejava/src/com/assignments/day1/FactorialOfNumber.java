package com.theLaxmi.Assignments;

public class FactorialOfNumber {

	public static void main(String[] args) {
		int num=4,factNum=1;
		for(int i=num;i>=1;i--) {
			factNum=factNum*i;
		}
		System.out.println("Factorial of number "+num+" is "+ factNum);
	}

}
