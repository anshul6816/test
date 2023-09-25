package com.mysql.crud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ResourceNotFoundException> ResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorDetails er = new ErrorDetails();
		er.setStatus(HttpStatus.NOT_FOUND.value());
		er.setMessage(ex.getMessage());

		return new ResponseEntity(er, HttpStatus.NOT_FOUND);
	}

}
