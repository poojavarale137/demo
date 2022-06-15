package com.example.springboot.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Repository.UserRepository;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User>  creatUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new  ResponseEntity<>(createdUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/user/{id}")
	public User UpdateUser(@RequestBody User user, @PathVariable Long id) {
		User UpdatedUser =userService.UpdateUser(user, id);
		return UpdatedUser;
	}
	
	@GetMapping("/users")
	public List<User> addusers() {
		List<User> addedUser = userService.getAllUsers();
		return addedUser;
	}
	
	@GetMapping("/user/{id}")
	public User adduserbyid(@PathVariable Long id) {
		User user = userService.getUserById(id);
		return user;
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteUser(@PathVariable Long id) {
		User user=userService.deleteUser(id);
		return user;
	}
	
	

}
