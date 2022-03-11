package com.example.demo.domain.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entities.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {

	Optional<Collection<Adress>> findByPersonId(Integer id);

}
