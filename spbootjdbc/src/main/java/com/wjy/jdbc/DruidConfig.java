/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: DruidConfig
 * Author:   wjy
 * Date:     2019/1/5 20:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/5
 * @since 1.0.0
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
        bean.addUrlMappings("/druid/*");
        Map initParams = new HashMap();
        initParams.put("loginUsername","admin");  //登录用户名
        initParams.put("loginPassword","123456"); //登录密码
        initParams.put("allow","");  //允许连接的ip地址
//        initParams.put("deny",""); //不允许连接的ip地址
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean getFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.addUrlPatterns("/*");
        Map initParams = new HashMap();
        initParams.put("exclusions","*.js,*.css,*.jpg,*.png,/druid/*"); //访问这些地址不会被druid监控
        bean.setInitParameters(initParams);
        return bean;
    }

}
