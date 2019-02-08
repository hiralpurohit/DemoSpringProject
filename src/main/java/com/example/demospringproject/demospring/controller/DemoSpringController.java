package com.example.demospringproject.demospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringproject.demospring.model.User;
import com.example.demospringproject.demospring.repository.UserRepository;

@RestController
@RequestMapping("/users")		
public class DemoSpringController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/getAllData")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User userData) {
		return userRepository.save(userData);
		
	}
	
	@GetMapping("/getOne/{id}")
	public User getOneUser(@PathVariable(value="id") Long userid) {
		return userRepository.findByUserId(userid);
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable(value="id") Long userid, @RequestBody User userDetails) {
		User user = userRepository.findByUserId(userid);
		
		user.setUserName(userDetails.getUserName());
		user.setMobno(userDetails.getMobno());
		
		User updatedUser = userRepository.save(user);
		
		return updatedUser;
		
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(value="id") Long userid) {
		User user = userRepository.findByUserId(userid);
		userRepository.delete(user);
		return "User Data Deleted Successfully";
	}

}
