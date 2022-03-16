package com.example.demo.domain.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter(value = AccessLevel.PRIVATE)
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private LocalDate birthday;
	
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY )
	private List<Address> addresses;

	private Person() {};
	
	public static Person of(final String name, final Integer age, final LocalDate birthday) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person.setBirthday(birthday);
		return person;
	}
	
	public static Person updateOf(final Person person, final String name, final Integer age) {
		person.setName(name);
		person.setAge(age);
		return person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, birthday, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return  Objects.equals(age, other.age)
				&& Objects.equals(birthday, other.birthday) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
}