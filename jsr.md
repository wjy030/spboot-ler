# springboot集成jsr303参数验证
* JSR303是java提供的以注解方式验证bean属性的标准
* Hibernate Validator 框架提供了对这一标准的实现
* spring boot集成了Hibernate Validator框架
## 使用方式
### bean上添加注解
```
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
```
@NotEmpty 是字段不能为空,message是自定义的错误信息  
还有的注解如:@NotNull,@Null,@NotBlank,@AssertTrue,@Size,@Length,@Past,@Future等等  
### 方法上启用验证注解
```
@PostMapping("/login")
public String doLogin(@Valid User user, BindingResult errors, HttpSession session, Model model) {
```
* 要验证的javabean参数加上@Valid注解可以启用bean中那些验证注解
* 在要验证的javabean参数后面紧跟Errors(接口)或BindingResult(Errors的实现)类型的参数可以收集验证失败的内容,
**注意必须紧跟要验证的javabean参数不能被其他参数隔开**
### thymeleaf上的配置
```
<label>用户名: </label><input type="text" name="username"><span style="color:red" th:errors="${user.username}" th:if="${user}"></span>
```
th:errors="${user.username}" 被验证的是User类型的参数中的username字段.则可以通过errors输出验证失败信息
