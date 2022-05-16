package com.theLaxmi.Assignments;
/*
 * *multiplication of ten in reverse order
 */
public class MultiplicationOfTen {

	public static void main(String[] args) {
		int n=10,multi=1;
		System.out.println("table of "+n);
		for(int i=10;i>=1;i--) {
			multi=n*i;
			System.out.println(n+" * "+i+" = "+multi);
		}


	}

}
