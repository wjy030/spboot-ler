# 整合freemarkder
引入freemarker启动器依赖
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-freemarker</artifactId>
</dependency>
```
ftl文件默认放在类路径/templates目录下
放入users.ftl文件,则controller中方法如下:
```
@GetMapping("/users")
public String doFree(Model model) {
    System.out.println("8***********");
    User u = new User();
    u.setId(1111);
    u.setUsername("mike");
    u.setPassword("1234");
    User u2 = new User();
    u2.setId(1111);
    u2.setUsername("Peter");
    u2.setPassword("54321");
    List<User> users = new ArrayList<>();
    users.add(u);
    users.add(u2);
    model.addAttribute("users",users);
    return "users";
}
```
