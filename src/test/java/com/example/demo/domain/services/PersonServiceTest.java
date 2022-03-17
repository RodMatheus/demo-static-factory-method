package com.example.demo.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.api.mapper.PersonMapper;
import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.api.model.input.PostAdress;
import com.example.demo.api.model.input.PostPerson;
import com.example.demo.domain.entities.Person;
import com.example.demo.domain.repositories.AddressRepository;
import com.example.demo.domain.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = PersonService.class)
public class PersonServiceTest {

	// PERSON - POST
	private static final String NAME_POST_PERSON = "Brian Domingues";
	private static final Integer AGE_POST_PERSON = 41;
	private static final LocalDate BIRTHDAY_POST_PERSON = LocalDate.of(1981, Month.MAY, 10);
	private static final String ZIPCODE_POST_PERSON = "71654134";
	private static final Integer PERSON_ID_POST_ADDRESS = 1;

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

	@Test
	public void cadastraPersonEAddressSucesso() {

		PostPerson postPerson = gerarPost(true);
		PersonService service = newPersonService();

		service.postPerson(postPerson);

		verify(personRepository, times(1)).save(any());
		verify(addressRepository, times(1)).save(any());
	}

	@Test
	public void cadastraPersonSucesso() {

		PostPerson postPerson = gerarPost(false);
		PersonService service = newPersonService();

		service.postPerson(postPerson);

		verify(personRepository, times(1)).save(any());
		verify(addressRepository, times(0)).save(any());
	}

	private PersonService newPersonService() {
		return new PersonService(personRepository, addressRepository);
	}

	private Person gerarNewPerson() {
		return Person.of(NAME_PERSON, AGE_PERSON, BIRTHDAY_PERSON);
	}

	private PostPerson gerarPost(boolean existAddress) {

		return PostPerson.builder().name(NAME_POST_PERSON).age(AGE_POST_PERSON).birthday(BIRTHDAY_POST_PERSON)
				.addresses(
						existAddress
								? List.of(PostAdress.builder().zipCode(ZIPCODE_POST_PERSON)
										.person(PERSON_ID_POST_ADDRESS).build())
								: Collections.emptyList())
				.build();
	}

	private PatchPerson gerarPatch() {
		return PatchPerson.builder().age(AGE_PATCH_PERSON).name(NAME_PATCH_PERSON).build();
	}
}