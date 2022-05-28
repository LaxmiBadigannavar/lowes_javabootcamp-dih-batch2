package com.labs.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List <String> cities =getCities().or
		
		//Optional<List<String>> cities  =getCities().or(()->Arrays.asList("Mumbai","Noida"));
		
		//List<String> cities = getCities();
		//	System.out.println(cities.get(0));
		
		String city1=getCity().orElse("Mumbai");
		System.out.println(city1);

	}

	private static List<String> getCities(){
		return Arrays.asList("Bangaluru","Mumbai","Pune","Delhi","Kolkata","Chenai");
		//return null;
	}
	//String city = getCity().isPresent()?getCity().get():getCity().orElse("Mumbai");
	
		
	//private Static String getCity() {
		//return "Begaluru";
		//return null;
	//}
	
	private  static Optional<String> getCity(){
		Optional<String> city = Optional.of("Bengaluru");
		return city;
	}
}
