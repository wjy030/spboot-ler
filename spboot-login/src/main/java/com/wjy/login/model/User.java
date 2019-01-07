/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: User
 * Author:   suneee
 * Date:     2019/1/7 11:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
@Entity
@Table(name="login_user")
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @Column(name = "reg_date")
    private Date regDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="uid")
    private List<Address> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
