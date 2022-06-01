package com.labs.spring.carapp;

public class Engine {
	String type;
	int capacity;
	
	public Engine() {
		
	}
	public Engine(String type, int capcity) {
		this.capacity = capacity;
		this.type = type;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
}
