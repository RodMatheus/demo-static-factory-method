package com.example.demo.api.mapper;

import java.util.Collection;

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

	PersonDTO toDTO(Person person);
	
	Collection<PersonDTO> toListDTO(Collection<Person> persons);
	
	@Mapping(ignore = true, source = "adress.person", target = "person")
	AddressDTO toAdressDTO(Address adress);

	@Mapping(ignore = true, target = "addresses")
	@Mapping(ignore = true, target = "id")
	@Mapping(ignore = true, target = "birthday")
	void uptadeFromPatch(PatchPerson patchPerson, @MappingTarget Person person);
}