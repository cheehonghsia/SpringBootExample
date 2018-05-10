package com.scrumtraveller.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scrumtraveller.springboot.domain.Greeting;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { GreetingService.class })
public class TestGreetingService {

	@Autowired
	GreetingService greetingService;

	@Test
	public void testGetGreeting() {
		Greeting greeting = this.greetingService.getGreeting();
		assertNotNull(greeting);
		assertEquals(2l, greeting.getId());
		assertEquals("Hello world", greeting.getContent());
	}
	
	@Test
	public void testGetGreetingWithName() {
		Greeting greeting = this.greetingService.getGreeting("foobar");
		assertNotNull(greeting);
		assertEquals(1l, greeting.getId());
		assertEquals("Hello foobar!", greeting.getContent());
	}

}
