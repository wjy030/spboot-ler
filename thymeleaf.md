# 整合thymeleaf模板
引入thymeleaf启动器
···
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
···
thymeleaf使用的文件仍然是html，在html文件中html元素上引入对应前缀：``<html lang="en" xmlns:th="http://www.thymeleaf.org">``  
## 输出变量
两种方式
1. 依附html标签: ``<div th:text="${user.id}"></div>``
2. 不依附html标签:``<span>[[${user.username}]]</span>``
## 几种输出:
* th:text   输出特殊字符会转义,
* th:utext  输出特殊字符不会转义,内容中有html文档时html会被解析
* th:value  对应input的value值
**html中大部分标签都有相应的th前缀的标签.比如th:href**
## string函数
格式:  
比如``<div th:text="${#strings.isEmpty(user.id)}"></div>``  
### 常用string函数
${#strings.isEmpty(user.id)} 字符串是否空
${#strings.contains(mother,child)} 母串中是否包含子串
${#strings.startsWith(user.id)} 
${#strings.endsWith(user.id)}
