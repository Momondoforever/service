package com.hausaufgabe.service.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonDB personDB;

    @Autowired
    public PersonService(PersonDB personDB) {
        this.personDB = personDB;
    }

    public List<Person> getPerson() {
        return personDB.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> pbn = personDB.findPersonByName(person.getName());
        if (pbn.isPresent()) {
            throw new IllegalStateException("Name vergeben");
        }
        personDB.save(person);
    }
    public void deletePerson(Integer personId) {
        boolean ex = personDB.existsById(personId);
        if (!ex) {
            throw new IllegalStateException("person mit id "+ personId + " existiert nicht");
        }
        personDB.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Integer Id, Person newPerson) throws IllegalStateException {
        String name = newPerson.getName();
        LocalDate geb = newPerson.getGeb();
        Person person = personDB.findById(Id).orElseThrow(() -> new IllegalStateException("person mit id "+ Id + " existiert nicht"));

        if (name != null && name.length() > 0) {
            person.setName(name);
        }
        if (geb != null) {
            person.setGeb(geb);
        }
    }

}
