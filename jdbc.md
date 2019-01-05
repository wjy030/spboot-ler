# 整合jdbc
引入jdbc启动器,jdbc驱动
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```
在全局配置文件配置数据库连接
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=wjy199889
spring.datasource.url=jdbc:mysql://localhost:3306/world?serverTimezone=UTC
```
springboot 启动时会根据配置的连接创建datasource,jdbcTemplate对象,我们可以直接使用
```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootjdbcApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void contextLoads() {
        System.out.println(jdbcTemplate.queryForList("select * from city"));
    }

}
```
