/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: FreeController
 * Author:   suneee
 * Date:     2019/1/4 16:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.freem.controller;

import com.wjy.freem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/4
 * @since 1.0.0
 */
@Controller
public class FreeController {

    @GetMapping("/users")
    public String doFree(Model model) {
        System.out.println("8***********");
        User u = new User();
        u.setId(1111);
        u.setUsername("mike");
        u.setPassword("1234");
        User u2 = new User();
        u2.setId(1111);
        u2.setUsername("Peter");
        u2.setPassword("54321");
        List<User> users = new ArrayList<>();
        users.add(u);
        users.add(u2);
        model.addAttribute("users",users);
        return "users";
    }
}
