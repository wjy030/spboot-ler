package com.wjy.jdbc;

import com.wjy.jdbc.Model.User;
import com.wjy.jdbc.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.wjy.jdbc.dao")
public class SpbootjdbcApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        System.out.println(dataSource.getClass());
        System.out.println(jdbcTemplate.queryForList("select * from city"));
    }
    @Test
    public void init() {
        User user = new User();
        user.setId(111);
        user.setCode("001");
        user.setName("Mike");
        userDao.add(user);
    }

}

