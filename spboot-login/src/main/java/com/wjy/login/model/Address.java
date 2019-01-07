/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: Address
 * Author:   suneee
 * Date:     2019/1/7 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.login.model;

import javax.persistence.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/7
 * @since 1.0.0
 */
@Entity
@Table(name="login_addr")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "address_info")
    private String addressInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }
}
