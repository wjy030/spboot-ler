# spring boot 启动
```
@SpringBootApplication
public class SpbootInit {

    public static void main(String[] args) {
        SpringApplication.run(SpbootInit.class,args);
    }
}
```

* @SpringBootApplication 标识该类为spring boot主启动类
* SpringApplication.run(SpbootInit.class,args); 启动spring boot
* 主启动类只会在所在包及其子包下搜索注解,所以**sping组件(如controller,service等)一般都要放在主启动类的子包下**
## maven 配置
```
<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.7.RELEASE</version>
	</parent>

	<!-- Add typical dependencies for a web application -->
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>

	<!-- Package as an executable jar -->
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
  ```
## spring boot 快速建立项目
* idea 新建项目时选择Spring Initializer
## spring boot 配置文件
* application.properties/application.yml **文件名固定这两种**  里面配置server.port=80就可以修改启动端口号
## spring boot 推荐目录结构
* static存放静态资源
* template存放模板
