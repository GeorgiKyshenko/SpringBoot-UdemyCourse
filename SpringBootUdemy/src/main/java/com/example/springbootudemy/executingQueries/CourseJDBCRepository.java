package com.example.springbootudemy.executingQueries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJDBCRepository {
    private JdbcTemplate springJDBCTemplate;

    @Autowired
    public CourseJDBCRepository(JdbcTemplate springJDBCTemplate) {
        this.springJDBCTemplate = springJDBCTemplate;
    }

    private static String CREATE_QUERY = """
            create table if not exists `course`
            (
            `id` bigint primary key not null,
            `name` varchar(255) not null,
            `author` varchar(255) not null
            );
            """;
    public void create() {
        springJDBCTemplate.execute(CREATE_QUERY);
    }

    private static String INSERT_QUERY = """
            insert into `course`(id,name,author)
            values('1','Learn Java', 'Georgi')
            """;

    public void insert() {
        springJDBCTemplate.update(INSERT_QUERY);
    }
}
