package com.myproject.Blogappapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.Blogappapi.modal.User;
import com.myproject.Blogappapi.payloads.UserDto;
import com.myproject.Blogappapi.repositories.UserRepo;
import com.myproject.Blogappapi.service.UserService;
import com.myproject.Blogappapi.Exception.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveduser =this.userRepo.save(user);
		
		return this.userToDto(saveduser) ;
	} 

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user =this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user","id",userId ));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		
		User updateuser = this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updateuser);
		
		
		return userDto1;
	}  

	@Override
	public UserDto getUserById(Integer Id) {
		User user = this.userRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("user","Id",Id) );
		return this.userToDto(user) ;
	}

	

	@Override
	public List<UserDto> getAllUser() {
		
		List<User> users =this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void DeleteUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "Id", userId)) ;
this.userRepo.delete(user);
	} 
	
	
	
	
	
	public User dtoToUser(UserDto userDto) {
		
		User user = modelMapper.map(userDto, User.class);
		
		
		
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
	}
	
	
	public UserDto userToDto(User user) {
		UserDto userDto =modelMapper.map(user, UserDto.class);
		
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		
		return userDto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
