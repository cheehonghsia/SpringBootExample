package com.scrumtraveller.springboot.service;

import com.scrumtraveller.springboot.domain.Greeting;

public interface IGreetingService {

	Greeting getGreeting();

	Greeting getGreeting(String name);

}
