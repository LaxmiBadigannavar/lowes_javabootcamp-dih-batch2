package com.examples.empapp.service;

import java.util.ArrayList;
import java.util.List;

import com.examples.empapp.model.User;

public class UserService {
	User user;
	public List<User> usersList = new ArrayList<>();
	public void addUser(User user) {
		usersList.add(user);
		System.out.println("User added to the list successfully");
	}
	public List<User> getUser() {
		return usersList;
	}
	
}
