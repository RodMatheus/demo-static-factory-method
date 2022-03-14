package com.example.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.domain.entities.Person;

@Service
public class PersonService {

	private final PersonMapper personMapper;
	
	@Autowired
	public PersonService(
			PersonMapper personMapper) {
		this.personMapper = personMapper;
	}

	public Person patchPerson(Person person, PatchPerson patchPerson) {
		
		personMapper.uptadeFromPatch(patchPerson, person);
		
		return person;
	}
}
