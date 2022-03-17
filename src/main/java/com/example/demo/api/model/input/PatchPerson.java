package com.example.demo.api.model.input;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Builder
@With
@Getter
public class PatchPerson {

	private String name;
	private Integer age;
}