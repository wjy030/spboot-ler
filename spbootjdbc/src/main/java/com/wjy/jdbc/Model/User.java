/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: User
 * Author:   wjy
 * Date:     2019/1/6 21:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.jdbc.Model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author wjy
 * @create 2019/1/6
 * @since 1.0.0
 */
public class User {
    private int id;
    private String name;
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
