package com.example.springbootudemy.executingQueries.commandRunner;

import com.example.springbootudemy.executingQueries.JDBCRepository;
import com.example.springbootudemy.models.Book;
import com.example.springbootudemy.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class jdbcCommandLineRunner implements CommandLineRunner {

    private JDBCRepository jdbcRepository;

    @Autowired
    public jdbcCommandLineRunner(JDBCRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        jdbcRepository.createBook();
        jdbcRepository.insertBook(new Book(1, "Learn Java", "Georgi"));
        System.out.println(jdbcRepository.findBookById(1)); // for the book to be mapped with values from the DB we need setter on our Bean/Class
//        jdbcRepository.deleteBookById(1);

        jdbcRepository.createCourse();
        jdbcRepository.insertCourse(new Course(1, "Udemy Course", "GeorgiK"));
//        jdbcRepository.deleteCourseById(1);
    }
}
