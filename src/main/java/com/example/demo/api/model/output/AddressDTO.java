package com.example.demo.api.model.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Builder
@With
@Getter
@JsonInclude(value = Include.NON_NULL)
public class AddressDTO {

	private String zipCode;
	private PersonDTO person;
}