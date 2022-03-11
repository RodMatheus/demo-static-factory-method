package com.example.demo.api.mapper;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.api.model.AdressDTO;
import com.example.demo.domain.entities.Adress;

@Mapper(componentModel = "spring")
public interface AdressMapper {

	@Mapping(ignore = true, source = "person.adresses",  target = "person.adresses")
	AdressDTO toDTO(Adress adress);
	
	Collection<AdressDTO> toListDTO(Collection<Adress> adresses);
}