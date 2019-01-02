/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: SpbootInit
 * Author:   suneee
 * Date:     2019/1/2 16:06
 * Description: 主启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.spboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈主启动类〉
 *
 * @author suneee
 * @create 2019/1/2
 * @since 1.0.0
 */
@SpringBootApplication
public class SpbootInit {

    public static void main(String[] args) {
        SpringApplication.run(SpbootInit.class,args);
    }
}
