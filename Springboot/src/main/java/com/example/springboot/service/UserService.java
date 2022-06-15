package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.User;

public interface UserService {
	User createUser(User user);
	User UpdateUser(User user,Long id);
	User getUserById(Long id);
	List<User> getAllUsers();
	User deleteUser(Long id);
	

}
