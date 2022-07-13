package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// http://localhost:8080/hello?name=Thorsten

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "Governikus") String firstname) {
		return "Hello " + firstname;
	}
}
