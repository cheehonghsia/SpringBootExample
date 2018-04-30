package com.scrumtraveller.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scrumtraveller.springboot.domain.Greeting;
import com.scrumtraveller.springboot.service.IGreetingService;

@RestController
public class GreetingController {

	@Autowired
	private IGreetingService greetingService;

	@RequestMapping(value = "/greeting", params = { "name" }, method = RequestMethod.GET)
	public Greeting greetingWithName(@RequestParam(value = "name", required = false) String name) {

		return this.greetingService.getGreeting(name);

	}

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting() {

		return this.greetingService.getGreeting();

	}

}