package com.labs.java.collection;

import java.util.HashSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		HashSet<String> countries = new HashSet<String>();
		countries.add("India");
		countries.add("Japan");
		countries.add("Australia");
		countries.add("India");
		countries.add("Japan");
		countries.add("Germany");
		countries.add(null);
		for(String item:countries) {
			System.out.println(item);
		}
		
		System.out.println();
		System.out.println("Using Treeset");
		TreeSet<String> countries1 = new TreeSet<String>();
		countries1.add("India");
		countries1.add("Japan");
		countries1.add("Australia");
		countries1.add("India");
		countries1.add("JAPAN");
		countries1.add("Germany");
		// countries1.add(null);
		for(String item:countries1) {
			System.out.println(item);
		}
		
	}

}
