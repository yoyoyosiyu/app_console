
### 

这个项目可以运行在两种模式下，这两种模式有着很大的不同

第一种模式是开发模式：
在这种模式下，前端的Angular是运行在单独的Web容器中，例如 Angular Server 或者是 Nginx，apache。而后台的API是运行在spring boot 内置
Tomcat中。前后端分离。



#### 关于分页以及排序的写法


http://{serverAddress}:{port}/api/products?page=0&size=20&sort=name,gender,asc&sort=age,desc

特别在多个字段的查询


### @EnableWebMvc 打开的的时候静态资源无法被访问的解决方法

https://stackoverflow.com/questions/24661289/spring-boot-not-serving-static-content


### Angular2 在 spring boot 的路由问题

当我们只是访问 http://localhost:8082/这样的路径的时候，spring boot 能够使用resources/static/index.html文件来响应，但是如果我们
访问类似如下的路径 http://localhost:8082/about这样的地址的时候，因为没有实际的about文件存在，所以需要我们把这样的路径交给
resources/static/index.html处理，那么我们需要进行必要的设置

https://stackoverflow.com/questions/38516667/springboot-angular2-how-to-handle-html5-urls