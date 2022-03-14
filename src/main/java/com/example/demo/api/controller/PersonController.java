package com.example.demo.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.mapper.AddressMapper;
import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.api.model.input.PostPerson;
import com.example.demo.api.model.output.AddressDTO;
import com.example.demo.api.model.output.PersonDTO;
import com.example.demo.domain.entities.Address;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AddressRepository;
import com.example.demo.domain.repositories.PersonRepository;
import com.example.demo.domain.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;
	private final PersonRepository personRepository;
	private final AddressRepository adressRepository;
	private final PersonMapper personMapper;
	private final AddressMapper adressMapper;

	@Autowired
	public PersonController(PersonService personService, PersonRepository personRepository,
			AddressRepository adressRepository, PersonMapper personMapper, AddressMapper adressMapper) {
		this.personService = personService;
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
	public ResponseEntity<Collection<AddressDTO>> getAdress(@PathVariable(name = "id") Integer id) {

		Collection<Address> addresses = adressRepository.findByPersonId(id).orElseThrow(RuntimeException::new);

		Collection<AddressDTO> dtos = adressMapper.toListDTO(addresses);
		return ResponseEntity.ok(dtos);
	}

	@PostMapping
	public ResponseEntity<Void> post(@RequestBody PostPerson postPerson) {
		
		personService.postPerson(postPerson);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.build();
	}
	
	@PatchMapping("/{id}")
	@Transactional
	public ResponseEntity<PersonDTO> patch(@PathVariable(name = "id") Integer id,
			@RequestBody PatchPerson patchPerson) {

		Person person = personRepository.findByIdToUpdate(id)
				.orElseThrow(RuntimeException::new);

		Person updatedPerson = personService.patchPerson(person, patchPerson);

		PersonDTO dto = personMapper.toDTO(updatedPerson);
		return ResponseEntity.ok(dto);
	}
}