package com.auth.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.model.User;
import com.auth.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	// http://localhost:8088/home/user
	
	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public List<User> getUser() {
		System.out.println("user");
		return this.userService.getUser();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
}
