# 整合jpa
## 引入jpa启动器
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
## 主配置文件配置
```
spring.datasource.url=jdbc:postgresql://127.0.0.1:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=wjy199889
spring.datasource.driver-class-name=org.postgresql.Driver
#spirng内部使用springdata,springdata里的jpa是用hibernate实现的
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
#使用postgresql要添加以下配置防止报:java.sql.SQLFeatureNotSupportedException: 这个 org.postgresql.jdbc.PgConnection.createClob() 方法尚未被实作
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false
```
## 使用jpa
### dao
```
public interface UserDao extends JpaRepository<User,Integer> {

}
```
### model
```
@Entity
@Table(name="sb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
### app
```
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbootJbaApplicationTests {
    @Autowired
    private UserDao userDao;
    @Test
    public void contextLoads() {
        User u = new User();
        u.setCode("003");
        u.setName("tark");
        userDao.save(u);
    }
}
```
