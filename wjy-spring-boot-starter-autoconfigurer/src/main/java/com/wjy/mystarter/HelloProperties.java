/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: HelloProperties
 * Author:   suneee
 * Date:     2019/1/8 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.mystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/8
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
