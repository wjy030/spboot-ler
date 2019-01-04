/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: FirstListener
 * Author:   wjy
 * Date:     2019/1/3 23:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/3
 * @since 1.0.0
 */
public class FirstListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
