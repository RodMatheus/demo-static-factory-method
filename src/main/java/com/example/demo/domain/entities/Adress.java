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
public class Adress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "zipcode")
	private String zipCode;
	
//	@Column(name = "person")
//	private Integer personId;
	
	@ManyToOne
	@JoinColumn(name = "person", updatable = false, insertable = false)
	private Person person;

	private Adress() {}
	
	public static Adress of(String zipCode, Person person) {
		Adress adress = new Adress();
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
		Adress other = (Adress) obj;
		return Objects.equals(id, other.id) && Objects.equals(person, other.person)
				&& Objects.equals(zipCode, other.zipCode);
	}
}