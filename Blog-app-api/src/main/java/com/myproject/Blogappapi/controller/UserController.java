package com.myproject.Blogappapi.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.myproject.Blogappapi.payloads.ApiResponse;
import com.myproject.Blogappapi.payloads.UserDto;
import com.myproject.Blogappapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto){
		UserDto createUserDto = service.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid   @RequestBody UserDto userDto ,@PathVariable Integer userId){
		
		UserDto updateuser=service.updateUser(userDto, userId);
		
		return ResponseEntity.ok(updateuser);
	
	}
	@DeleteMapping("/{uid}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer uid ){
		service.DeleteUser(uid);
		return new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully",true) ,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> showalluser(){
//		service.getAllUser();
		return ResponseEntity.ok(service.getAllUser()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> usergetbyid(@PathVariable Integer id){
		return ResponseEntity.ok(service.getUserById(id));
	}

}
