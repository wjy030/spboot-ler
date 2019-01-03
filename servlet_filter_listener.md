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
## 整合filter的两种方式
### 通过@WebFilter和@ServletComponentScan注解
```
@WebFilter(urlPatterns = "/first")
public class FirstFilter implements Filter {
```
通过@WebFilter定义Filter组件
```
@SpringBootApplication
@ServletComponentScan
public class SpbootInit {
```
主启动类加上@ServletComponentScan注解使之能扫描Filter组件
### 通过方法
```
@Bean
public FilterRegistrationBean getFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
    bean.addUrlPatterns("/*");
    return bean;
}
```
在配置类中通过以上方法注册Filter组件
## 整合Listener
常用的listener:  
* ServletContextListener  监听web的启动和关闭
* ServletContextAttributeListener 监听ServletContext范围内属性改变
* ServletRequestListener  监听用户请求
* ServletRequestAttributeListener 监听ServletRequest范围属性改变
* HttpSessionListener  监听session的开始和结束
* HttpSessionAttributeListener 监听session范围属性改变
### 通过@WebListener
和servlet,filter类似.用到了@WebListener和@ServletComponentScan注解
### 通过方法
```
@Bean
public ServletListenerRegistrationBean getListener() {
    ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new FirstListener());
    return bean;
}
```
