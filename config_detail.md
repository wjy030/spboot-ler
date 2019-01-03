# 配置文件详细使用
yaml和properties中一样的方式
```
user:
  id: ${random.int}
  username: ${random.value}
  birthday: 2011/11/11
  gender: true
  password: ${random.uuid}
  parents:
    Father: ${random.int(10)}
    Mother: ${user.username}
    Grandpa: ${aaa:park}
  roles: [admin,customer]
```
结果:User{id=816888298, username='5bf570b64e6425b1597983492e2fff81', password='d3a50165-2f0e-4410-8166-a3626de66ac6', 
birthday=Fri Nov 11 00:00:00 CST 2011, gender=true, roles=[admin, customer], parents={Father=7, 
Mother=94613c548a6c99e46756aafc9660dd2d, Grandpa=park}}
## 随机函数random的几种使用方式
* ${random.int} 随机整数
* ${random.value} 随机字符串
* ${random.uuid} 随机uuid
* ${random.int(10)} 1到9的随机整数
### 变量使用
* ${user.username} 使用容器中bean的成员变量
* ${aaa:park} 使用aaa属性,如果没有aaa属性则使用默认值park
## profile 使用
系统会运行在正式,测试等多种环境下,需要多套配置,可以使用profile准备多套配置,激活想要使用的配置
### properties
#* properties默认配置文件application.properties,可以准备application-test.properties,application-produce.properties两套文件,
在application.properties中配置spring.profiles.active=test 则会激活application-test.properties,配置spring.profiles.active=produce激活
application-produce.properties文
* 附属配置文件名格式为application-配置名.properties
### yaml
* yaml通过文档块实现profile
```
server:
  port: 8011
spring:
  profiles:
    active: test
  
---
server:
  port: 8022
spring:
  profiles: test
  
---
server:
  port: 8033
spring:
  profiles: produce
```
不同文档块以 --- 分隔
```
spring:
  profiles: produce 
```
定义所在文档块的名称
```
spring:
  profiles:
    active: test
```
定义激活的文档块
## 通过命令激活文档块
* 在启动参数program arguments 中加上--spring.profiles.active=test
* 在vm参数 VM options 中加上 -Dspring.profiles.active=test
## 注意
**激活的profile和默认主配置文件中的配置会同时起效,激活的profile中的配置有最高的优先级**  
**通过命令行激活的优先级比在文档中激活的优先级高**
## 多配置文件下的优先级
application.properties/application.yml 在不同的目录下可以存在多个,**这些文件会同时生效,但不同位置的文件优先级有区别**:
* 最高优先级: 通过命令行指定 --spring.config.location=x:xxx/application.properties
* 第二优先级: 项目根目录/config/application.properties
* 第三优先级: 项目根目录/application.properties
* 第四优先级: 类路径(也就是classes目录下)/config/application.properties
* 第五优先级: 类路径/application.properties
## 配置项
spring boot 2.0.7版本常用配置项介绍:https://docs.spring.io/spring-boot/docs/2.0.7.RELEASE/reference/htmlsingle/ 中的X. Appendices  
其中的配置都是通过@Configuration+@Bean实现的.  
spring boot 默认的配置类并不会全部加载. 会通过@ConditionalXXX 注解判断,只有满足条件的配置类才会加载
