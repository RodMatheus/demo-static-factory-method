package com.example.demo.api.model.input;

import java.time.LocalDate;
import java.util.Collection;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostPerson {

	private String name;
	private Integer age;
	private LocalDate birthday;
	
	private Collection<PostAdress> addresses;
}