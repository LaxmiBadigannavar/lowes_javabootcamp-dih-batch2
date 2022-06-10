package com.empapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.empapp.exception.LoginException;
import com.empapp.model.NewUser;
import com.empapp.model.User;
import com.empapp.service.UserService;
@Controller
@SessionAttributes("newuser")
public class NewUserController {
	//List<User> users = new ArrayList<User>();
	private static final Logger logger = LoggerFactory.getLogger(NewUserController.class);
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)	
	public ModelAndView newuser(Model model) {

		return new ModelAndView("newuser", "command", new User());
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	//@ExceptionHandler(LoginException.class)
	public ModelAndView addUser(@ModelAttribute User user, Model model) {
		System.out.println("going to newuser controller: "+user.getUserName());
		String username = user.getUserName();
		String password = user.getPassword();
		//User user = new User(username,password);
		UserService service = new UserService();
		service.addUser(new User(username,password));
		System.out.println("User added successfully");
		return new ModelAndView("redirect:/");
		
	}
	
	 
	
	
	
}
