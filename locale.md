# spring boot 国际化
## 默认国际化配置文件
* resources目录下建立messages.properties 默认配置
* 建立messages_zh_CN.properties 中文配置
* 建立messages_en_US.properties 英文配置
## thymeleaf模板中使用国际化配置中的变量
配置的变量``welcome=欢迎欢迎``  
thymeleaf中通过#{}使用``<h1>[[#{welcome}]]</h1>``
## 自定义国际化配置文件
在主配置文件配置``spring.messages.basename=local.msg``  
则默认国际化配置文件变成resources目录下/local/msg.properties
## 自定义国际化处理类
实现LocaleResolver接口,实现resolveLocale方法自定义国际化处理方式
```
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String locale = httpServletRequest.getParameter("lang");
        if (Objects.equals(locale, "zh")) {
            return new Locale("zh", "CN");
        } else if (Objects.equals(locale, "en")) {
            return new Locale("en","US");
        } else {
            return Locale.getDefault();
        }
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
```
通过@Bean创建MyLocaleResolver的实例
```
@Configuration
public class LocaleConfig {

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
```
