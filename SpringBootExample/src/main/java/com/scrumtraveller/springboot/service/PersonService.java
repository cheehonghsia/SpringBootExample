package com.scrumtraveller.springboot.service;

import java.util.List;

import com.scrumtraveller.springboot.domain.Person;

public interface PersonService {

	Person getPerson(int id);

	List<Person> getAllPerson();

}
