# 自定义启动器
## 创建
建立启动器模块(Maven),建立自动配置模块(Spring Initializer),启动器依赖自动配置模块  
* 启动器pom
```
<modelVersion>4.0.0</modelVersion>
<groupId>com.wjy.mystart</groupId>
<artifactId>wjy-spring-boot-starter</artifactId>
<version>1.0-SNAPSHOT</version>
<dependencies>
    <dependency>
        <groupId>com.wjy.mystarter</groupId>
        <artifactId>wjy-spring-boot-starter-autoconfigurer</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
</dependencies>
```
* 自动配置pom
```
<modelVersion>4.0.0</modelVersion>
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.1.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.wjy.mystarter</groupId>
<artifactId>wjy-spring-boot-starter-autoconfigurer</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>wjy-spring-boot-starter-autoconfigurer</name>
<description>Demo project for Spring Boot</description>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
</dependencies>
```
启动器模块不需要再写其他代码
## 自动配置模块结构
### 接收来自主配置文件的参数
```
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private String suffix;  //能接收主配置文件hello.suffix属性

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
```
通过@ConfigurationProperties(prefix = "hello")接收主配置文件中hello前缀,和字段对应的属性值
### 启动器的功能实例
```
public class HelloService {

    private HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public void service(String str) {
        System.out.println("执行启动器:"+str+helloProperties.getSuffix());
    }
}
```
启动器的目的就是读取配置并将该类的实例注入spring容器
### 自动配置类
```
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    public HelloService helloService() {
       HelloService helloService = new HelloService();
       helloService.setHelloProperties(helloProperties);
       return helloService;
    }
}
```
* @ConditionalOnWebApplication 只会在web应用中(检测到web启动器时)启用该配置
* @EnableConfigurationProperties(HelloProperties.class) 实现:1.创建HelloProperties实例; 2.将主配置文件中对应的属性注入HelloProperties实例; 
3. 将HelloProperties注入容器  
* helloService()方法中实现功能实例的创建并能使用主配置文件中的属性
### spring.factories
在resources中创建/META-INF/spring.factories,其中配置:
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.wjy.mystarter.HelloServiceAutoConfiguration
```
在应用程序启动过程中，Spring Boot使用SpringFactoriesLoader类加载器查找
org.springframework.boot.autoconfigure.EnableAutoConfiguration关键字对应的Java配置文件。
Spring Boot会遍历在各个jar包种META-INF目录下的spring.factories文件，构建成一个配置文件链表。
除了EnableAutoConfiguration关键字对应的配置文件，还有其他类型的配置文件：   
org.springframework.context.ApplicationContextInitializer  
org.springframework.context.ApplicationListener  
org.springframework.boot.SpringApplicationRunListener  
org.springframework.boot.env.PropertySourceLoader  
org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider  
org.springframework.test.contex.TestExecutionListener 

Spring Boot的starter在编译时不需要依赖Spring Boot的库。
