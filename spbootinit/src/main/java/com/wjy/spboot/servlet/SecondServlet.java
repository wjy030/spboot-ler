/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: FirstServlet
 * Author:   wjy
 * Date:     2019/1/3 21:55
 * Description: 测试servelet
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试servelet〉
 *
 * @author wjy
 * @create 2019/1/3
 * @since 1.0.0
 */
@WebServlet(urlPatterns = "/second")
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("再次执行doGet");
    }
}
