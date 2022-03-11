package com.example.demo.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}