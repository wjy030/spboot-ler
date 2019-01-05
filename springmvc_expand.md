# 对springmvc扩展配置
如果springboot提供的默认配置不满足要求则需要对其进行扩展
```
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }
}
```
* 建立一个配置类,注解@Configuration
* 实现WebMvcConfigurer接口
* 通过实现WebMvcConfigurer接口的方法来对springmvc进行扩展
**如果对该类用了@EnableWebMvc注解,则springboot提供的默认配置全部失效,需要自己重新配置**
