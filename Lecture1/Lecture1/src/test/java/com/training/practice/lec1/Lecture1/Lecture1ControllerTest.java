package com.training.practice.lec1.Lecture1;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest  //Tells springboot to create an application context for testing purposes
@AutoConfigureMockMvc  //This annotation configures mock mvc instance that stimulates the http requests in tests
class Lecture1ControllerTest {

	@Autowired //It injects an instance of mockmvc in the test class
	private MockMvc mockMvc;

	@Test //Annotation for J unit 5 that marks a method as test method
	public void testHelloWorldSuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hello-world"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Hello World!")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.at", Matchers.notNullValue()));
	}

}
