# 整合druid
## 引入相关依赖
```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>LATEST</version>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>LATEST</version>
</dependency>
```
因为druid依赖log4j框架,而spring boot依赖的是slf4j+loback 所以要加入log4j依赖
## 添加log4j配置文件log4j.properties
内容举例:
```
log4j.rootLogger=debug,stdout
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.Threshold=INFO
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p %m%n
```
## 全局配置文件
```
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
druid.driver-class-name=com.mysql.cj.jdbc.Driver
druid.username=root
druid.password=wjy199889
druid.url=jdbc:mysql://localhost:3306/world?serverTimezone=UTC
druid.minIdle=5
druid.maxActive=20
druid.maxWait=60000
druid.timeBetweenEvictionRunsMillis=60000
druid.minEvictableIdleTimeMillis=300000
druid.validationQuery=select 1
druid.testWhileIdle=true
druid.testOnBorrow=false
druid.testOnReturn=false
druid.poolPreparedStatements=true
druid.filters=stat,wall,log4j
druid.maxPoolPreparedStatementPerConnectionSize=20
druid.useGlobalDataSourceStat=true
druid.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500
```
spring.datasource.type 指定数据源类型  
因为springboot没有对druid的支持,所以需要自己创建DataSource对象并注入所需参数.
**druid开头的都是自定义的属性,用来帮助注入参数**  
## 创建DataSource对象
```
@Bean
@ConfigurationProperties(prefix = "druid")
public DataSource dataSource() {
    return new DruidDataSource();
}
```
@ConfigurationProperties(prefix = "druid") 将全局配置中druid前缀的属性注入到创建的对象中
# druid监控配置
需要配置Servlet和Filter
```
@Bean
public ServletRegistrationBean getServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet());
    bean.addUrlMappings("/druid/*");
    Map initParams = new HashMap();
    initParams.put("loginUsername","admin");  //登录用户名
    initParams.put("loginPassword","123456"); //登录密码
    initParams.put("allow","");  //允许连接的ip地址
//        initParams.put("deny",""); //不允许连接的ip地址
    bean.setInitParameters(initParams);
    return bean;
}

@Bean
public FilterRegistrationBean getFilter() {
    FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
    bean.addUrlPatterns("/*");
    Map initParams = new HashMap();
    initParams.put("exclusions","*.js,*.css,*.jpg,*.png,/druid/*"); //访问这些地址不会被druid监控
    bean.setInitParameters(initParams);
    return bean;
}
```
WebStatFilter 实现了druid对web应用的数据库访问监控  
StatViewServlet 实现对druid监控平台的访问
## 访问druid
http://localhost:8080/druid/login.html
