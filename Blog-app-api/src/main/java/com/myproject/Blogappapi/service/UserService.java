package com.myproject.Blogappapi.service;

import java.util.List;

import com.myproject.Blogappapi.payloads.UserDto;

public interface UserService {
	
	 UserDto createUser(UserDto userDto);
	 
	 UserDto updateUser(UserDto userDto,Integer userId);
	 UserDto getUserById(Integer Id);
	 void DeleteUser(Integer userId);
	 List<UserDto> getAllUser();
	 

}
