package com.example.demo.api.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.demo.api.model.input.PatchPerson;
import com.example.demo.api.model.output.AddressDTO;
import com.example.demo.api.model.output.PersonDTO;
import com.example.demo.domain.entities.Address;
import com.example.demo.domain.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	default List<PersonDTO> toSimpleListResource(Collection<Person> persons) {
		return persons
				.stream()
				.map(person -> toSimpleResource(person))
				.toList();
	}
	
	@Mapping(ignore = true, target = "addresses")
	PersonDTO toSimpleResource(Person person);
	
	PersonDTO toResource(Person person);
	
	@Mapping(ignore = true,  target = "person", source = "person")
	AddressDTO toAdressResource(Address adress);

	@Mapping(ignore = true, target = "addresses")
	@Mapping(ignore = true, target = "id")
	@Mapping(ignore = true, target = "birthday")
	default void uptadeFromPatch(PatchPerson patchPerson, @MappingTarget Person person) {
		if(person != null && patchPerson != null) {
			Person.updateOf(person, patchPerson.getName(), patchPerson.getAge());
		}
	}
}