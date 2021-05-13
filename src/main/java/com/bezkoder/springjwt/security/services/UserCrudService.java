package com.bezkoder.springjwt.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.repository.UserCrudRepository;



@Service
@Transactional
public class UserCrudService {
	
	private final UserCrudRepository userCrudRepository;

	public UserCrudService(UserCrudRepository userCrudRepository) {
		this.userCrudRepository=userCrudRepository;
	}
	
	public void saveMyUser(User user ) {
		userCrudRepository.save(user);
	}
	
	public Iterable<User> showAllUsers(){
		return userCrudRepository.findAll();
	}
	
	public Iterable<User> deleteUserByUsername(String username) {
		userCrudRepository.deleteByUsername(username);
		return userCrudRepository.findAll();
	}
	
	public Optional<User> editUser(int id) {
		return userCrudRepository.findById(id);
	}
	
	public User findByUsername(String username) {
		return userCrudRepository.findByUsername(username);
	}
	
	}
	
