/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: JspController
 * Author:   suneee
 * Date:     2019/1/4 12:00
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

import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/4
 * @since 1.0.0
 */
@Controller
public class JspController {

    @Resource
    private User user;
    @GetMapping("/jsptest")
    public String index(Model model) {
        System.out.println("hello********************"+user);
       model.addAttribute("user",user);
        return "index";
    }
}
