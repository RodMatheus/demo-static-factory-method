package com.example.demo.domain.repositories;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("FROM Person p WHERE p.id = :id ")
	Optional<Person> findByIdToUpdate(Integer id);

}