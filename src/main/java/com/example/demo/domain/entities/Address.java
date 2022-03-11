package com.example.demo.domain.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(value = AccessLevel.PRIVATE)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "zipcode")
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "person")
	private Person person;

	private Address() {}
	
	public static Address of(String zipCode, Person person) {
		Address adress = new Address();
		adress.setZipCode(zipCode);
		adress.setPerson(person);
		
		return adress;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, person, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(id, other.id) && Objects.equals(person, other.person)
				&& Objects.equals(zipCode, other.zipCode);
	}
}