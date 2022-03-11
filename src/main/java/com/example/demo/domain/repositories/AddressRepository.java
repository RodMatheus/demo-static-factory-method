package com.example.demo.domain.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	Optional<Collection<Address>> findByPersonId(Integer id);

}
