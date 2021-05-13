package com.bezkoder.springjwt.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.security.services.UserCrudService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin
public class RestController {

	@Autowired
	private UserCrudService userCrudService;

	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user, HttpServletRequest request) {
		userCrudService.saveMyUser(user);
		return "Hello "+user.getFirstname()+", your registration is successful!";
	}
	
	@GetMapping("/all-users")
	public Iterable<User> showAllUsers() {
		return userCrudService.showAllUsers();
	}
	
	@GetMapping("/delete/{username}")
	public Iterable<User> deleteUser(@PathVariable String username){
		return userCrudService.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	public User searchUser(@PathVariable String username) {
		return userCrudService.findByUsername(username);
	}
	
}
