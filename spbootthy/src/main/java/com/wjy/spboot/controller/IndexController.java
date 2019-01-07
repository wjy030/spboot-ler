/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: IndexController
 * Author:   wjy
 * Date:     2019/1/4 21:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.controller;

import com.wjy.spboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/4
 * @since 1.0.0
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest req, HttpSession session) {
        User user = new User();
        user.setId(1);
        user.setUsername("aaa");
        user.setPassword("3333");
        User user1 = new User();
        user1.setId(2);
        user1.setUsername("bbb");
        user1.setPassword("4444");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        Map u1 = new HashMap();
        u1.put("code","11111");
        u1.put("name","park");
        model.addAttribute("map",u1);
        model.addAttribute("user",user);
        model.addAttribute("users",users);
        model.addAttribute("con1","yes");
        model.addAttribute("con2","no");
        model.addAttribute("say","我要显示");
        req.setAttribute("req001","req请求");
        session.setAttribute("ses","session请求");
        session.getServletContext().setAttribute("sc","application请求");
        return "idx";
    }
}
