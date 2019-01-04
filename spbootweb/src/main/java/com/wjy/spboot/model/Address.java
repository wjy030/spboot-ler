/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: Address
 * Author:   wjy
 * Date:     2019/1/2 23:10
 * Description: 地址
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈地址〉
 *
 * @author wjy
 * @create 2019/1/2
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "address")
public class Address {

    private int id;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
