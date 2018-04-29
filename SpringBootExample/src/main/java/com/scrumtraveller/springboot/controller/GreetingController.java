package com.scrumtraveller.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scrumtraveller.springboot.domain.Greeting;
import com.scrumtraveller.springboot.service.IGreetingService;

@RestController
public class GreetingController {

	@Autowired
	private IGreetingService greetingService;

	@RequestMapping("/greeting")
	public Greeting greeting() {
		return this.greetingService.getGreeting();

	}
}