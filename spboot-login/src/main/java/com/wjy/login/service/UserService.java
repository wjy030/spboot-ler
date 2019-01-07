/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: UserService
 * Author:   suneee
 * Date:     2019/1/7 12:04
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.service;

import com.wjy.login.dao.UserDao;
import com.wjy.login.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;
    public User getUserByName(String userName) {
       User user = userDao.getByUsername(userName);
       Assert.notNull(user,"用户名不存在");
       return user;
    }

}
