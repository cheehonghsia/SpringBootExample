package com.scrumtraveller.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.scrumtraveller.springboot.domain.Greeting;
import com.scrumtraveller.springboot.service.IGreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GreetingController.class, secure = false)
public class TestGreetingController {

	@Autowired
	private MockMvc mockMVC;
	@MockBean
	private IGreetingService greetingService;

	@Test
	public void retrieveGreeting() throws Exception {

		// Return JSON looks like this: {"id":1,"content":"Hello world"}
		Greeting greeting = new Greeting(1l, "Hello World");

		Mockito.when(greetingService.getGreeting()).thenReturn(greeting);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMVC.perform(requestBuilder).andReturn();

		String expected = "{\"id\":1,\"content\":\"Hello World\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

}