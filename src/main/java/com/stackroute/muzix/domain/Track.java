package com.stackroute.muzix.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//An entity is a plain old Java object (POJO)
// class that is mapped to the database and configured for usage through JPA using annotations and/or XML.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {

    @Id
    //marks the field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column  //represents column of the table
    private String name;

    @Column  //represents column of the table
    private String comment;

}
