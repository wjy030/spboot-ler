/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: SpTest
 * Author:   wjy
 * Date:     2019/1/2 23:29
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot;


import com.wjy.spboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试〉
 *
 * @author wjy
 * @create 2019/1/2
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpTest {

    @Autowired
    private User user;

    @Test
    public void init() {
        System.out.println("***************"+user);
    }
}
