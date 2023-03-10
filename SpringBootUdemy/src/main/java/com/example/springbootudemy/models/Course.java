package com.example.springbootudemy.models;

import lombok.Setter;

@Setter
public class Course {
    private long id;
    private String courseName;
    private String author;

    public Course(int id, String courseName, String author) {
        this.id = id;
        this.courseName = courseName;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAuthor() {
        return author;
    }
}
