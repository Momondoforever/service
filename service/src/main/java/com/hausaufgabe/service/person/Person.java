package com.hausaufgabe.service.person;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_seq",
            sequenceName = "person_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_seq"
    )
    private Integer id;
    private String name;
    private LocalDate geb;

    public Person() {
    }

    public Person(String name, LocalDate age) {
        this.name = name;
        this.geb = age;
    }

    public Person(Integer id, String name, LocalDate age) {
        this.id = id;
        this.name = name;
        this.geb = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getGeb() {
        return geb;
    }

    public void setGeb(LocalDate geb) {
        this.geb = geb;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + geb +
                '}';
    }
}
