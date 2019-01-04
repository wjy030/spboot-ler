# 整合静态资源
## springboot中有几个默认可以存在静态资源的目录
* classpath:/META-INF/resources
* classpath:/resources
* classpath:/static
* classpath:/public
* / 项目根路径
* src/main/webapp
## 也可以在全局配置中指定
spring.resources.static-locations=classpath:resources,classpath:wjy
## spring boot默认的首页是放在任一静态资源目录下的index.html
## spring boot默认的web页面图标是放在任一静态资源目录下的favicon.ico
