package com.company.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.company.usermanagement.dto.UserDto;
import com.company.usermanagement.entity.User;
import com.company.usermanagement.exception.UserNotFoundException;
import com.company.usermanagement.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User registerUser(UserDto dto) {

	    User user = new User();
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setPassword(dto.getPassword());

	    user.setRole("USER");
	    user.setStatus(true);

	    return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: " + id));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User updateUser(Long id, UserDto dto) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setPassword(dto.getPassword());

	    return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
	    User user = userRepository.findById(id)
	            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

	    userRepository.delete(user);
	}

	@Override
	public User login(String email, String password) {
	    User user = userRepository.findByEmail(email)
	            .orElseThrow(() -> new UserNotFoundException("Invalid email"));

	    if (!user.getPassword().equals(password)) {
	        throw new RuntimeException("Invalid password");
	    }

	    return user;
	}

	
	

}
