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
## 使用内置函数
格式:  
比如``<div th:text="${#strings.isEmpty(user.id)}"></div>``  
### 常用string函数
* ${#strings.isEmpty(user.id)} 字符串是否空
* ${#strings.contains(mother,child)} 母串中是否包含子串
* ${#strings.startsWith(mother,child)} 母串是否以子串开始
* ${#strings.endsWith(mother,child)} 母串是否以子串结束
* ${#strings.indexOf(mother,child)} 返回子串在母串中的位置
* ${#strings.substring(mother,start,end)} 截取字符串
* ${#strings.toUpperCase(mother)} 转为大写
### dates 函数
* ${#dates.format(date,'yyyy-MM-dd HH:mm:ss')} 日期格式化
* ${#dates.year(date)} 获取年
* ${#dates.month(date)} 获取月
* ${#dates.day(date)} 获取日
## 条件选择
### if选择
```
<div th:if="${con1}=='yes'">
    <span th:text="${say}"></span>
</div>
```
### switch选择
```
<div th:switch="${user.id}">
    <div th:case="1">我是1</div>
    <div th:case="2">我是2</div>
    <div th:case="3">我是3</div>
</div>
```
### 迭代
```
<div th:each="u:${users}">
    <div th:text="${u.username}"></div>
    <div th:text="${u.password}"></div>
</div>
```
#### 状态变量
```
<div th:each="u,var:${users}">
    <div th:text="${u.username}"></div>
    <div th:text="${u.password}"></div>
    <div th:text="${var.index}"></div>
    <div th:text="${var.count}"></div>
    <div th:text="${var.size}"></div>
    <div th:text="${var.even}"></div>
    <div th:text="${var.odd}"></div>
    <div th:text="${var.first}"></div>
    <div th:text="${var.last}"></div>
</div>
```
var是内置的状态变量  
* ${var.index} 当前循环的索引,从0开始
* ${var.count} 当前循环的次数,从1开始
* ${var.size} 集合的长度
* ${var.even} 当前循环是否偶数,从0开始
* ${var.odd} 当前循环是否奇数,从0开始
* ${var.first} 当前循环是否第一条
* ${var.last} 当前循环是否最后一条
### map 迭代
```
Map u1 = new HashMap();
u1.put("code","11111");
u1.put("name","park");
model.addAttribute("map",u1);
```
```
<div th:each="e:${map}">
    <div th:text="${e}"></div>
</div>
```
输出结果:  
key1=value1  
key2=value2  
进一步:  
```
<div th:each="e:${map}">
    <div th:each="ent:${e}" th:text="${ent.key}"></div>
    <div th:each="ent:${e}" th:text="${ent.value}"></div>
</div>
```
### HttpServletRequest,HttpSession,ServletContext使用
thymeleaf提供了内置变量: #httpServletRequest,session,application  
``req.setAttribute("req001","req请求");`` 对应 ``<div th:text="${#httpServletRequest.getAttribute('req001')}"></div>``.
``session.setAttribute("ses","session请求");`` 对应 ``<div th:text="${session.ses}"></div>``
``session.getServletContext().setAttribute("sc","application请求");`` 对应 ``<div th:text="${application.sc}"></div>``

