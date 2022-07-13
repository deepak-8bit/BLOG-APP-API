package com.myproject.Blogappapi.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.myproject.Blogappapi.payloads.ApiResponse;

import net.bytebuddy.implementation.FieldAccessor.FieldNameExtractor;

@RestControllerAdvice
public class GloballyExceptionHandlar {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourecenotfoundException(ResourceNotFoundException  ex){
		String message =ex.getMessage();
		ApiResponse response=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND );
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		
		Map<String,String> resp=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fieldName = ((FieldError)error).getField();
			
			String message =error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		
		
		return    new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST) ;
		
		
		
	}

}
