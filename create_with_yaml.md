# 根据配置文件(yml或properties)生成spring bean
以yaml为例
```
@ConfigurationProperties(prefix = "user")
@Component
public class User {

    private int id;
    private String name;
    private String password;
    private Date birthday;
    private boolean gender;
    private Address address;
```
* @Component注释该类为spring bean
* @ConfigurationProperties(prefix = "user") 标注该spring bean在配置文件中对应的属性
yaml中的对应配置:
```
user:
  id: 100
  name: wjy
  birthday: 2011/11/11
  gender: true
  password: 123456
  parents: {father: Jack,Mother: Mary}
  roles: [admin,customer]
  address: {id: 300,address: aaaaa}
```
其中address对应的类:
```
@Component
@ConfigurationProperties(prefix = "address")
public class Address {
    private int id;
    private String address;
```
所以spring bean对应的属性不一定必须是顶级属性
## 根据@ConfigurationProperties生成spring bean时是支持jsr303数据交验的
```
@ConfigurationProperties(prefix = "user")
@Component
@Validated
public class User {

    private int id;
    @NotEmpty
    private String name;
```
@NotEmpty会起作用
