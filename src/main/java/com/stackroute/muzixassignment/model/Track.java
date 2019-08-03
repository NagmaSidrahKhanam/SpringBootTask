package com.stackroute.muzixassignment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Track")
public class Track {
    @Id//marks id as primary key
    private int id;


    private String name;


    private String Comments;

    public Track() {
    }

    public Track(int id, String name, String comments) {
        this.id = id;
        this.name = name;
        Comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                ", lastName='" + Comments + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        this.Comments = comments;
    }



}
