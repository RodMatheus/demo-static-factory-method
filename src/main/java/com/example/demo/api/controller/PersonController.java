package com.example.demo.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.mapper.AddressMapper;
import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.AddressDTO;
import com.example.demo.api.model.PersonDTO;
import com.example.demo.domain.entities.Address;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AddressRepository;
import com.example.demo.domain.repositories.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private final PersonRepository personRepository;
	private final AddressRepository adressRepository;
	private final PersonMapper personMapper;
	private final AddressMapper adressMapper;
	
	@Autowired
	public PersonController(PersonRepository personRepository,
			AddressRepository adressRepository,
			PersonMapper personMapper,
			AddressMapper adressMapper) {
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
	public ResponseEntity<Collection<AddressDTO>> getAdress(@PathVariable(name = "id") Integer id){
		
		Collection<Address> addresses = adressRepository.findByPersonId(id).orElseThrow(RuntimeException::new);
		
		Collection<AddressDTO> dtos = adressMapper.toListDTO(addresses);
		return ResponseEntity.ok(dtos);
	}
	
}