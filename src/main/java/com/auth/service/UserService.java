package com.auth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.model.User;
import com.auth.repository.UserRepository;

@Service
public class UserService {

	/*
	 * private List<User> list=new ArrayList<>(); public UserService() {
	 * list.add(new User(1, "user", "user@gmail.com", "123456")); list.add(new
	 * User(2, "user", "user@gmail.com", "123456")); list.add(new User(3, "user",
	 * "user@gmail.com", "123456")); list.add(new User(4, "user", "user@gmail.com",
	 * "123456")); list.add(new User(5, "user", "user@gmail.com", "123456")); public
	 * List<User> getUser() { return this.list; } }
	 */

	@Autowired
	private UserRepository urepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getUser() {
		return this.urepo.findAll();
	}

	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return this.urepo.save(user);
	}

}
