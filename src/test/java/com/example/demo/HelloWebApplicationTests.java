package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
class HelloWebApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHello() throws Exception {
		mockMvc.perform(get("/hello").param("name", "Thorsten")) //
				.andExpect(status().isOk()) //
				.andExpect(MockMvcResultMatchers.content().string("Hello Thorsten"));
	}

	@Test
	void testEcho() throws Exception {
		String user = new ObjectMapper().writeValueAsString(new User("Thorsten", "Maier"));
		mockMvc.perform(post("/echo") //
				.content(user) //
				.contentType(MediaType.APPLICATION_JSON)) //
				.andExpect(status().isOk()) //
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstname", "Thorsten").exists());
	}

}
