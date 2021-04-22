package com.springmvc.springmongodbweb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;

/**
 *
 * @author didin
 */
@Document(collection = "persons")
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String affiliation;


    public String getId() {
        return id;
    }

    public Person setId(String id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public Person setAffiliation(String affiliation) {
        this.affiliation = affiliation;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", affiliation='" + affiliation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id,person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(affiliation, person.affiliation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, email, affiliation);
    }
}
