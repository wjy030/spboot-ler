# spring boot 错误处理
## spring boot 会访问的错误页面
1. spring boot默认会访问**/模板引擎目录/error/错误代码命名的页面** 如/templates/error/404.html
2. 如果没有发现页面,则会在**静态资源目录/error**下查找,如/static/error/404.html
3. 如果还没有就会使用默认页面
4. 还可以将错误分成客户端错误4xx和服务端错误5xx两类,分别访问4xx.html和5xx.html. 如: /templates/error/4xx.html
## spring mvc 的错误处理spring boot中都可以使用
[参考spring mvc错误处理](https://github.com/wjy030/springmvc-ler/blob/master/exception.md)
