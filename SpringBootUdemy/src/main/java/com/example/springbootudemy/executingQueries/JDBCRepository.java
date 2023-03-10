package com.example.springbootudemy.executingQueries;

import com.example.springbootudemy.models.Book;
import com.example.springbootudemy.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCRepository {
    private JdbcTemplate springJDBCTemplate;

    @Autowired
    public JDBCRepository(JdbcTemplate springJDBCTemplate) {
        this.springJDBCTemplate = springJDBCTemplate;
    }

    //BOOK QUERIES
    private static String CREATE_QUERY_FOR_BOOK = """
            CREATE TABLE IF NOT EXISTS `books`
            (
            `id` bigint PRIMARY KEY NOT NULL,
            `name` varchar(255) NOT NULL,
            `author` varchar(255) NOT NULL
            );
            """;

    public void createBook() {
        springJDBCTemplate.execute(CREATE_QUERY_FOR_BOOK);
    }

    private static String INSERT_QUERY_FOR_BOOK = """
            INSERT INTO `books`(id,name,author)
            VALUES(?,?,?)
            """;

    public void insertBook(Book book) {
        springJDBCTemplate.update(INSERT_QUERY_FOR_BOOK, book.getId(), book.getName(), book.getAuthor());
    }

    private static String DELETE_QUERY_FOR_BOOK = """
            DELETE FROM `books` WHERE `id` = ?;
            """;

    public void deleteBookById(long id) {
        springJDBCTemplate.update(DELETE_QUERY_FOR_BOOK, id);
    }

    private static String SELECT_BOOK = """
            select * from `books` where `id` = ?;
            """;

    public Book findBookById(long id) {
        return springJDBCTemplate.queryForObject(SELECT_BOOK, new BeanPropertyRowMapper<>(Book.class),id);
        //BeanPropertyRowMapper maps the ResultSet we get from the query to the Bean (Java class - Book) with id
    }

    //COURSE QUERIES
    private static String CREATE_QUERY_FOR_COURSE = """
            CREATE TABLE IF NOT EXISTS `courses`
            (
            `id` bigint PRIMARY KEY NOT NULL,
            `course_name` varchar(255) NOT NULL,
            `author` varchar(255) NOT NULL
            );
            """;

    public void createCourse() {
        springJDBCTemplate.execute(CREATE_QUERY_FOR_COURSE);
    }

    private static String INSERT_QUERY_FOR_COURSE = """
            INSERT INTO `courses`(id,course_name,author)
            VALUES(?,?,?) // we can hardcore the values, but now we are getting them from the object
            """;

    public void insertCourse(Course course) {
        springJDBCTemplate.update(INSERT_QUERY_FOR_COURSE, course.getId(), course.getCourseName(), course.getAuthor());
    }

    private static String DELETE_QUERY_FOR_COURSE = """
            DELETE FROM `courses` WHERE `id` = ?;
            """;

    public void deleteCourseById(long id) {
        springJDBCTemplate.update(DELETE_QUERY_FOR_COURSE, id);
    }
}
