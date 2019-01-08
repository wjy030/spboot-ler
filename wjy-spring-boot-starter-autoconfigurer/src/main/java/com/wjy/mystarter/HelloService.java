/**
 * Copyright (C), 2015-2019, 上海象翌微链有限公司
 * FileName: HelloService
 * Author:   suneee
 * Date:     2019/1/8 15:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.wjy.mystarter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author suneee
 * @create 2019/1/8
 * @since 1.0.0
 */
public class HelloService {

    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public void service(String str) {
        System.out.println("执行启动器:"+str+helloProperties.getSuffix());
    }
}
