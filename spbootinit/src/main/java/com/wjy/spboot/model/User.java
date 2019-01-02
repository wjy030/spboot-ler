/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: User
 * Author:   wjy
 * Date:     2019/1/2 23:09
 * Description: 用户
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户〉
 *
 * @author wjy
 * @create 2019/1/2
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "user")
@Component
public class User {

    private int id;
    private String name;
    private String password;
    private Date birthday;
    private boolean gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", roles=" + roles +
                ", parents=" + parents +
                '}';
    }

    private List<String> roles;
    private Map parents;

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Map getParents() {
        return parents;
    }

    public void setParents(Map parents) {
        this.parents = parents;
    }
}
