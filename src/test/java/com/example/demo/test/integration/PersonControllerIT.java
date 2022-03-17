package com.example.demo.test.integration;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;

public class PersonControllerIT extends BaseIT{
	
	private final String BASE_PATH = "/person";
	
	@Test
	public void getPersonSucesso() {
		given()
			.accept(ContentType.JSON)
			.basePath(BASE_PATH)
			.port(port)
		.when()
			.get()
		.then()
			.statusCode(HttpStatus.OK.value());
	}
}