package com.example.demo.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.mapper.AdressMapper;
import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.AdressDTO;
import com.example.demo.api.model.PersonDTO;
import com.example.demo.domain.entities.Adress;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AdressRepository;
import com.example.demo.domain.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final PersonRepository personRepository;
	private final AdressRepository adressRepository;
	private final PersonMapper personMapper;
	private final AdressMapper adressMapper;
	
	@Autowired
	public PersonController(PersonRepository personRepository,
			AdressRepository adressRepository,
			PersonMapper personMapper,
			AdressMapper adressMapper) {
		this.personRepository = personRepository;
		this.adressRepository = adressRepository;
		this.personMapper = personMapper;
		this.adressMapper = adressMapper;
	}

	@GetMapping
	public ResponseEntity<Collection<PersonDTO>> get() {
				
		List<Person> persons = personRepository.findAll();
		
		Collection<PersonDTO> dtos = personMapper.toListDTO(persons);
		return ResponseEntity.ok(dtos);
	}
	
	@GetMapping("/{id}/adresses")
	public ResponseEntity<Collection<AdressDTO>> getAdress(@PathVariable(name = "id") Integer id){
		
		Collection<Adress> adresses = adressRepository.findByPersonId(id).orElseThrow(RuntimeException::new);
		
		Collection<AdressDTO> dtos = adressMapper.toListDTO(adresses);
		return ResponseEntity.ok(dtos);
	}
	
}