package com.techelevator.dao;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcMoodDaoTests extends BaseDaoTests {

    private JdbcUserDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcUserDao(jdbcTemplate);
    }

}
