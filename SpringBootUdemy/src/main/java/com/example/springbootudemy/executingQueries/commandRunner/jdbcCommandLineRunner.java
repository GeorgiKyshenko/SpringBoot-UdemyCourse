package com.example.springbootudemy.executingQueries.commandRunner;

import com.example.springbootudemy.executingQueries.CourseJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class jdbcCommandLineRunner implements CommandLineRunner {

    private CourseJDBCRepository jdbcRepository;

    @Autowired
    public jdbcCommandLineRunner(CourseJDBCRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.create();
        jdbcRepository.insert();
    }
}
