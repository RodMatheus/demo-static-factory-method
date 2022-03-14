package com.example.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.api.model.input.PostPerson;
import com.example.demo.domain.entities.Address;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AddressRepository;
import com.example.demo.domain.repositories.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;
	private final AddressRepository addressRepository;
	private final PersonMapper personMapper;

	@Autowired
	public PersonService(
			PersonRepository personRepository,
			AddressRepository addressRepository,
			PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.addressRepository = addressRepository;
		this.personMapper = personMapper;
	}

	public Person patchPerson(Person person, PatchPerson patchPerson) {

		personMapper.uptadeFromPatch(patchPerson, person);

		return person;
	}

	@Transactional
	public void postPerson(PostPerson postPerson) {
		final Person person = personRepository
				.save(
						Person.of(
									postPerson.getName(),
									postPerson.getAge(),
									postPerson.getBirthday()));
		
		if(postPerson.getAddresses() != null && 
				!postPerson.getAddresses().isEmpty()) {
			
			postPerson.getAddresses()
			  .stream()
			  .forEach(address -> {
				  Address adress = Address.of(address.getZipCode(), person);
				  addressRepository.save(adress);
			  });
		}
	}
}