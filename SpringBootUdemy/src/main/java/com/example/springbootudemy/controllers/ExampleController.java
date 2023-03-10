package com.example.springbootudemy.controllers;

import com.example.springbootudemy.models.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ExampleController {

    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "Georgi"),
                new Course(2, "Learn DevOps", "Georgi Tangardzhiev"),
                new Course(3, "Learn Azure", "Georgi Kyshenko"),
                new Course(4, "Learn JS", "Georgi Kyshenko"),
                new Course(5, "Learn React", "Georgi Kyshenko"));
    }
}
