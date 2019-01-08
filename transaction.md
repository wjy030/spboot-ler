# 事务配置
spring boot 开启事务只要在主启动类加上@EnableTransactionManagement
```
@SpringBootApplication
@EnableTransactionManagement
public class SpbootjdbcApplication {
```
然后就可以使用@Transactional了
## 事务管理器
* 根据项目依赖的是jdbc启动器还是jpa启动器,springboot会注入DataSourceTransactionManager或JpaTransactionManager
* 也可以**自己指定事务管理器**
```
@Bean
public PlatformTransactionManager txManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
}
```
spring boot会使用自己创建的事务管理器替代默认的.
