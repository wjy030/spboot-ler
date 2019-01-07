# 整合mybatis
## 引入mybatis启动器
```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>LATEST</version>
</dependency>
```
## 建mybatis配置文件,并在主配置文件配上.如:  
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml  //mybatis映射文件  
mybatis.config-location=classpath:mybatis/mybatis-config.xml  //mybatis配置文件  
mybatis.check-config-location=true //是否检查配置文件,默认false  


**mybatis.config-location 可以不配,springboot提供了mybatis配置文件中的一些配置项可以配置在主配置文件中
,如:mybatis.configuration.map-underscore-to-camel-case=true**  
## 设置扫描包路径
```
@MapperScan("com.wjy.jdbc.dao")
public class SpbootjdbcApplicationTests {
```
在测试类或启动类用注解设置dao类的扫描包
