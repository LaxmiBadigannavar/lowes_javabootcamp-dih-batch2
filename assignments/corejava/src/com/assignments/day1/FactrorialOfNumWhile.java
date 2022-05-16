package com.theLaxmi.Assignments;

public class FactrorialOfNumWhile {

	public static void main(String[] args) {
		int num=6,factNum=1;
		int i=num;
		while(i>=1) {
			factNum=factNum*i;
			i--;
		}
		System.out.println("Factorial of number "+num+" is "+ factNum);
	}
}
