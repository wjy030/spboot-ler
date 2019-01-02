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
