package com.scrumtraveller.springboot.service;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.scrumtraveller.springboot.domain.Greeting;

@Service
public class GreetingService implements IGreetingService {

	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

	@Override
	public Greeting getGreeting() {
		return new Greeting(counter.incrementAndGet(), "Hello world");
	}

	@Override
	public Greeting getGreeting(String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
