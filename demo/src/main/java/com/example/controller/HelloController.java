package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class HelloController {

	@GetMapping("/hi")
	public ResponseEntity<String> m1() {
		
		System.out.println("Hi Tushar, Welcome!!!!!!!!!");
		return ResponseEntity.status(HttpStatus.OK).body("\"Hi Tushar, Welcome!!!!!!!!!\"");
	}
}
