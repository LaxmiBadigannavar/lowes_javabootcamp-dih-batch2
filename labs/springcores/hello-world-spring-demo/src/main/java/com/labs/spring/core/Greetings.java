package com.labs.spring.core;

public class Greetings {

		String message="Hello World";
		public Greetings() {
			
		}
		public Greetings(String message) {
			this.message = message;
		}
		
		
		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

}
