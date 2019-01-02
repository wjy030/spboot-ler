/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: HelloController
 * Author:   suneee
 * Date:     2019/1/2 16:08
 * Description: 欢迎
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈欢迎〉
 *
 * @author suneee
 * @create 2019/1/2
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {
       return "hello world 22";
    }
}
