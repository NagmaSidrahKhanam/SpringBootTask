package com.stackroute.muzixassignment.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
// class that is mapped to the database and configured for usage through JPA using annotations and/or XML.

public class Track {
    @Id //makes id as primary key
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Track() {
    }

    public Track(int id,String firstName,String lastName,int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
