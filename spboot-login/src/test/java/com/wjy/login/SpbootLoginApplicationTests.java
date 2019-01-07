package com.wjy.login;

import com.wjy.login.dao.UserDao;
import com.wjy.login.model.Address;
import com.wjy.login.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootLoginApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User u = new User();
        u.setUsername("Arthas");
        u.setPassword("123456");
        u.setRegDate(new Date());
        Address a1 = new Address();
        a1.setAddressInfo("江苏");
        Address a2 = new Address();
        a2.setAddressInfo("上海");
        List<Address> as = new ArrayList<>();
        as.add(a1);
        as.add(a2);
        u.setAddresses(as);
        userDao.save(u);
    }

}

