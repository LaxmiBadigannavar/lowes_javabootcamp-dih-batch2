package com.spring.rest.empapp.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMessage {
	private String status;
	private String message;
	
	public ResponseMessage(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ResponseMessage() {
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
