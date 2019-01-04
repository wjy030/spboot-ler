/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: FirstFilter
 * Author:   wjy
 * Date:     2019/1/3 22:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/3
 * @since 1.0.0
 */
@WebFilter(urlPatterns = "/*")
public class FirstFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行 firstfilter 以前");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("执行 firstfilter 以后");
    }

    @Override
    public void destroy() {

    }
}
