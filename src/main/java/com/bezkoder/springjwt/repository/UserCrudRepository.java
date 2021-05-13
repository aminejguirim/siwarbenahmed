package com.bezkoder.springjwt.repository;

import org.springframework.data.repository.CrudRepository;

import com.bezkoder.springjwt.models.User;


public interface UserCrudRepository extends CrudRepository<User, Integer> {	
	
	public User findByUsername(String username);
	
	public Iterable<User> deleteByUsername(String username); 

}
