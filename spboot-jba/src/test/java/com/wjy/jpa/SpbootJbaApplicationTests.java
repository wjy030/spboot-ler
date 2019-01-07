package com.wjy.jpa;

import com.wjy.jpa.dao.UserDao;
import com.wjy.jpa.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootJbaApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User u = new User();
        u.setCode("003");
        u.setName("tark");
        userDao.save(u);
    }

}

