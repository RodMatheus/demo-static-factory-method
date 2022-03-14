package com.example.demo.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.api.model.output.AddressDTO;
import com.example.demo.domain.entities.Address;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	@Mapping(ignore = true, source = "person.addresses",  target = "person.addresses")
	AddressDTO toDTO(Address address);
	
	Collection<AddressDTO> toListDTO(Collection<Address> adresses);
}