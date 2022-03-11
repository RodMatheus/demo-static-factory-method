package com.example.demo.api.model;

import java.time.LocalDate;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Builder
@With
@Getter
@JsonInclude(value = Include.NON_NULL)
public class PersonDTO {

	private String name;
	private Integer age;
	private LocalDate birthday;
	
	private Collection<AddressDTO> addresses;
}