package com.stackroute.muzix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//An entity is a plain old Java object (POJO)
// class that is mapped to the database and configured for usage through JPA using annotations and/or XML.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private int id;
    private String firstname;
    private String lastname;
    private int age;

   }