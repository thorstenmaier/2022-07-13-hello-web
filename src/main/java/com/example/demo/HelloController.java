package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	// http://localhost:8080/hello -> hello()

	@RequestMapping("/hello")
	public String hello() {
		return "Hello Governikus";
	}
}
