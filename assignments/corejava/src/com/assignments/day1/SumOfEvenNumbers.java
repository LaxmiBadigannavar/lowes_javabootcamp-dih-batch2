package com.theLaxmi.Assignments;

import java.util.Scanner;

public class SumOfEvenNumbers {

	public static void main(String[] args) {
		int sum=0,i=1;
		int count=1;
		int num=10;
		while(count<=num){
			if(i%2==0) {
				sum=sum+i;
				count++;
			}	
				i++;
		}
		System.out.println("Sum of n no. of even numbers= "+sum);
	}

}
