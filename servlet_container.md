# spring boot中的servlet容器
## spring支持的嵌入容器
* tomcat 生产也能用
* jetty 小巧,速度快
* undertow 非阻塞servlet
## 对容器进行配置
主配置文件提供了对这些容器的配置属性  
* server.XXX 通用的配置属性
* server.tomcat.XXX tomcat的配置属性
* server.jetty.XXX jetty的配置属性
* server.undertow.XXX undertow的配置属性
## 更换嵌入容器
排除默认的tomcat启动器依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <groupId>org.springframework.boot</groupId>
        </exclusion>
    </exclusions>
</dependency>
```
加入新的容器启动器依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```
## 使用外部tomcat部属
* 建立/webapp/WEB-INF目录结构,如果不是用的servlet 3.0规范,要建web.xml文件
* pom.xml中<packaging>war</packaging> 项目打成war包
* 然后可以在tomcat部属
