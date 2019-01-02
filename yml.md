# yaml配置文件语法
yaml文件功能和properties功能一样,但语法有区别
## 基本语法
key: value  
冒号后面必须加至少一个空格  
## 层级
yaml有着清晰的层次结构
```
server:
  port: 80
```
所有左对齐的元素都同一层级
## 定义对象
两种方式:  
第一种  
```
User:
  username: aaa
  age: 18
```
第二种  
```
User: {username: aaa,age: 18}
```
yaml中字符串默认不用加引号
## 定义数组
两种方式:  
第一种  
```
Tool:
  - car
  - trunk
  - bus
```
第二种  
```
Tool: [car,trunk,bus]
```
