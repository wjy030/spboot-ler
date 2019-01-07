/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: UserDao
 * Author:   suneee
 * Date:     2019/1/7 11:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.dao;

import com.wjy.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
public interface UserDao extends JpaRepository<User,Integer> {

   public User getByUsername(String userName);
}
