package com.example.demo.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.api.model.AddressDTO;
import com.example.demo.api.model.PersonDTO;
import com.example.demo.domain.entities.Address;
import com.example.demo.domain.entities.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	PersonDTO toDTO(Person person);
	
	Collection<PersonDTO> toListDTO(Collection<Person> persons);
	
	@Mapping(ignore = true, source = "adress.person", target = "person")
	AddressDTO toAdressDTO(Address adress);
}