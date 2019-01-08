/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: MyLocaleResolver
 * Author:   suneee
 * Date:     2019/1/8 11:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/8
 * @since 1.0.0
 */
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String locale = httpServletRequest.getParameter("lang");
        if (Objects.equals(locale, "zh")) {
            return new Locale("zh", "CN");
        } else if (Objects.equals(locale, "en")) {
            return new Locale("en","US");
        } else {
            return Locale.getDefault();
        }
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
