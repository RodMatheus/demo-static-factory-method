package com.example.demo.domain.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AddressRepository;
import com.example.demo.domain.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PersonService.class )
public class PersonServiceTest {

	// PERSON - PATCH
	private static final String NAME_PATCH_PERSON = "Brian ADAMS";
	private static final Integer AGE_PATCH_PERSON = 46;

	// PERSON - ENTITY
	private static final String NAME_PERSON = "Brian Domingues";
	private static final Integer AGE_PERSON = 41;
	private static final LocalDate BIRTHDAY_PERSON = LocalDate.of(1981, Month.MAY, 10);

	
	@MockBean
	private PersonRepository personRepository;
	
	@MockBean
	private AddressRepository addressRepository;
	
	@MockBean
	private PersonMapper personMapper;
	
	@Test
	public void atualizaPersonSucesso() {
		PatchPerson patchPerson = gerarPatch();
		Person person = gerarNewPerson();
		
		PersonService service = newPersonService();
		
		Person updated = service.patchPerson(person, patchPerson);
		
		assertThat(updated.getName()).isEqualTo(NAME_PATCH_PERSON);
	}
	
	private PersonService newPersonService() {
		return new PersonService(personRepository, addressRepository);
	}
	
	private Person gerarNewPerson( ) {
		return Person.of(NAME_PERSON, AGE_PERSON, BIRTHDAY_PERSON);
	}
	
	private PatchPerson gerarPatch( ) {
		return PatchPerson.builder()
				.age(AGE_PATCH_PERSON)
				.name(NAME_PATCH_PERSON)
				.build();
	}
}