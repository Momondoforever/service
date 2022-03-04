package com.hausaufgabe.service.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDB
        extends JpaRepository<Person, Integer> {

    Optional<Person> findPersonByName(String name);
}
