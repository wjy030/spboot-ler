/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: LoginController
 * Author:   suneee
 * Date:     2019/1/7 12:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.controller;

import com.wjy.login.model.User;
import com.wjy.login.service.UserService;
import com.wjy.mystarter.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Resource
    private HelloService helloService;
    @Resource
    private UserService userService;

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "login";
        } else {
            return "redirect:index";
        }
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/wel")
    public String wel() {
        helloService.service("天河");
        return "wel";
    }
    @PostMapping("/login")
    public String doLogin(User user, HttpSession session, Model model) {
        try {
            User u = userService.getUserByName(user.getUsername());
            Assert.state(Objects.equals(user.getPassword(), u.getPassword()), "密码错误");
            session.setAttribute("user", u);
            return "redirect:index";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}
