package com.mongoDB.crud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFound.class)
	ResponseEntity<ResourceNotFound> ResourceNotFoundException(ResourceNotFound ex){
		
		ErrorDetails er= new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		
		return new ResponseEntity(er,HttpStatus.NOT_FOUND);
	}
	
}
