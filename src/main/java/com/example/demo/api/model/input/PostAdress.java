package com.example.demo.api.model.input;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostAdress {

	private String zipCode;
	private Integer person;
}
