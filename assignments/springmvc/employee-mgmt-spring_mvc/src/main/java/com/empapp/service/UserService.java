package com.empapp.service;

import java.util.ArrayList;
import java.util.List;

import com.empapp.dao.UserDaoImpl;
import com.empapp.model.User;

public class UserService {
	User user;
	UserDaoImpl userdao = new UserDaoImpl();
	//public List<User> usersList = new ArrayList<>();
	public void addUser(User user) {
		//usersList.add(user);
		userdao.insertUser(user);
		System.out.println("User added to the list successfully");
	}
	public List<User> getUsers() {
		List<User> users = userdao.getUsers();
		//System.out.println("userList in servicec"+users);
		return users;
	}
	
}
