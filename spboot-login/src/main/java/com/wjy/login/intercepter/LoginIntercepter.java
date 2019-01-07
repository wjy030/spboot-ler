/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: LoginIntercepter
 * Author:   suneee
 * Date:     2019/1/7 15:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.intercepter;

import com.wjy.login.model.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
public class LoginIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null) {
            request.setAttribute("error","您还没有登录,请登录!");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        } else {
            return true;
        }
    }
}
