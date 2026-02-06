package com.company.usermanagement.service;

import java.util.List;

import com.company.usermanagement.dto.UserDto;
import com.company.usermanagement.entity.User;

public interface UserService {
	
	User registerUser(UserDto userDto);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	User updateUser(Long id, UserDto dto);
	
	void deleteUser(Long id);
	
	User login(String email, String password);

	

}
