# spring 整合servlet,filter,listener
## 整合servlet两种方式
### 通过@WebServlet和@ServletComponentScan注解
```
@WebServlet(urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
```
通过@WebServlet定义servlet组件
```
@SpringBootApplication
@ServletComponentScan
public class SpbootInit {
```
主启动类加上@ServletComponentScan注解使之能扫描servlet组件
### 通过方法
```
@Bean
public ServletRegistrationBean getBean() {
    ServletRegistrationBean bean = new ServletRegistrationBean();
    bean.setServlet(new SecondServlet());
    bean.addUrlMappings("/second");
    return bean;
}
```
在配置类中通过以上方法注册servlet组件
##
