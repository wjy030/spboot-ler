/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: UserDao
 * Author:   wjy
 * Date:     2019/1/6 20:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.jdbc.dao;

import com.wjy.jdbc.Model.User;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/6
 * @since 1.0.0
 */
public interface UserDao {

    int add(User user);
    List<User> select(Map params);
    int update(User user);
    int delete(int id);
}
