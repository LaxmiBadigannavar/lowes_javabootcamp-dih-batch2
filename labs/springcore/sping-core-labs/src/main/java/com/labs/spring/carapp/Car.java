package com.labs.spring.carapp;

public class Car {
	String model;
	String manufacture;
	String color;
	
	Engine engine;
	public Car() {
		
	}
	public Car(Engine engine) {
		this.engine = engine;
	}
	
	public Car(String model, String manufacture, String color, Engine engine) {
		super();
		this.model = model;
		this.manufacture = manufacture;
		this.color = color;
		this.engine = engine;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
