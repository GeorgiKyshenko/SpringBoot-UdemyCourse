package com.example.springbootudemy.SpringJDBC.commandRunner;

import com.example.springbootudemy.SpringJDBC.JDBCRepository;
import com.example.springbootudemy.SpringJPA.JPARepository;
import com.example.springbootudemy.SpringJPA.JPAmodel.Employee;
import com.example.springbootudemy.models.Book;
import com.example.springbootudemy.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component this component works with "application-prod.properties"
public class JDBCCommandLineRunner implements CommandLineRunner {
    // im using one CommandLineRunner class for testing SpringJDBC and SpringJPA
    private JDBCRepository jdbcRepository;
    private JPARepository jpaRepository;

    @Autowired
    public JDBCCommandLineRunner(JDBCRepository jdbcRepository, JPARepository jpaRepository) {
        this.jdbcRepository = jdbcRepository;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Spring JDBC examples
        //if you start the app for a SECOND time there will be primary key conflict for insertBook and insertCourse
        // because they are already persisted by the FIRST run of the app !

        jdbcRepository.createBook();
        jdbcRepository.insertBook(new Book(1, "Learn Java", "Georgi"));
        System.out.println(jdbcRepository.findBookById(1)); // for the book to be mapped with values from the DB we need setter on our Bean/Class
//        jdbcRepository.deleteBookById(1);

        jdbcRepository.createCourse();
        jdbcRepository.insertCourse(new Course(1, "Udemy Course", "GeorgiK"));
//        jdbcRepository.deleteCourseById(1);

        //Spring JPA examples
        //in the JPA examples won`t be any primary key conflicts because the id is annotated with GenerationType.IDENTITY
        // you are just going to have a lot of employees with the same name and different ids (if not changed)

        jpaRepository.insert(new Employee("Georgi", "Kyshenko"));
        System.out.println(jpaRepository.findById(1));
//        jpaRepository.deleteById(1);
    }
}
