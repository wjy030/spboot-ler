/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: IndexController
 * Author:   wjy
 * Date:     2019/1/6 17:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.jdbc.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.sql.DataSource;
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
@Controller
public class IndexController {

    @Resource
    private JdbcTemplate template;

    @GetMapping("/index")
    public String index(Model model) {
        List<Map<String, Object>> maps = template.queryForList("select * from city");
        model.addAttribute("citys",maps);
        return "index";
    }
}
