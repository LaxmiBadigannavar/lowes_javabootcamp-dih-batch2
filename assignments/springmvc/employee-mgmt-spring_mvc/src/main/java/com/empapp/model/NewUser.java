package com.empapp.model;

public class NewUser {
	private String id;
	private String repass;
	private String emailid;
	User user;
	public NewUser() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public NewUser(User user) {
		super();
		this.user = user;
	}
	public NewUser(String id) {
		super();
		this.id = id;
	}
	
	public NewUser(String repass, String emailid, User user) {
		super();
		this.repass = repass;
		this.emailid = emailid;
		this.user = user;
	}
}
