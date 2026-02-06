package com.company.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.usermanagement.dto.UserDto;
import com.company.usermanagement.entity.User;
import com.company.usermanagement.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserDto userDto) {
	    User savedUser = userService.registerUser(userDto);
	    return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
	    User user = userService.getUserById(id);
	    return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id,
	                                       @Valid @RequestBody UserDto dto) {
	    User updated = userService.updateUser(id, dto);
	    return ResponseEntity.ok(updated);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
	    userService.deleteUser(id);
	    return ResponseEntity.ok("User deleted successfully");
	}


	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestParam String email,
	                                  @RequestParam String password) {
	    return ResponseEntity.ok(userService.login(email, password));
	}

	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
	    return ResponseEntity.ok(userService.getAllUsers());
	}


}
