package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/users")
	public List<User> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(path = "/users/add", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE)
	public User save(@RequestBody User user) {
		return service.save(user);
	}

	@RequestMapping(path = "/users/update", method = RequestMethod.PUT, consumes = MediaType.ALL_VALUE)
	public User update(@RequestBody User user) {
		return service.Update(user);
	}

	@RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable int id) {
		return service.findOne(id);
	}	
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable int id) {
		service.delete(id);
		return true;
	}

}
