# swagger-bootstarp-ui演示项目

# 说明

swagger-bootstrap-ui的jar包已经上传到maven中央仓库,可以直接使用，目前的版本是1.3

[中央仓库地址](http://search.maven.org/#search%7Cga%7C1%7Cswagger-bootstrap-ui)

maven配置

```java
<dependency>
    <groupId>com.drore.cloud</groupId>
    <artifactId>swagger-bootstrap-ui</artifactId>
    <version>1.3</version>
</dependency>

```

1、该项目是Spring boot项目,直接main方法运行`SwaggerBootstrapUiDemoApplication`即可

2、端口是`application.properties`中配置的8999
```java
server.port=8999
```

3、访问http://localhost:8999/doc.html