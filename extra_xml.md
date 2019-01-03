# 引入额外的spring bean 配置文件
```
@SpringBootApplication
@ImportResource("classpath:spring.xml")
public class SpbootInit {
```
@ImportResource 可以引入其他spring bean配置文件,配置文件中定义的bean可以被spring容器管理  
 spring不推荐如此方法,推荐@Configuration+@Bean注解
