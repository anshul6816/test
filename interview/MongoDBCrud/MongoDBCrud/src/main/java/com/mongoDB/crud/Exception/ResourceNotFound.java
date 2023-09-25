package com.mongoDB.crud.Exception;

import org.springframework.stereotype.Component;


public class ResourceNotFound extends Exception{
	
	public ResourceNotFound(String message){
		super(message);
	}

}
