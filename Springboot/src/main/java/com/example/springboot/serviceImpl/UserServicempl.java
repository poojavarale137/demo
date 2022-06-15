package com.example.springboot.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.springboot.exception.*;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@Service
public class UserServicempl implements UserService{
 
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		User Saveduser=userRepository.save(user);
		return Saveduser;
	}

	@Override
	public User UpdateUser(User user, Long id) {
		User user1 = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		
		User updatedUser = userRepository.save(user1);
		return updatedUser;
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","id",id));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		List<User>  newUser=users.stream().map(user -> user).collect(Collectors.toList());
		return newUser;
	}

	@Override
	public User deleteUser(Long id) {
		 User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id", id));
		 userRepository.delete(user);
		return user;
	}

}
