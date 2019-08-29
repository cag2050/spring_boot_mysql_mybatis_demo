* Spring Boot 使用 MyBatis 例子

### 步骤一：创建项目
一、构建工具选择：maven 

二、使用 Spring Initializr 创建此 Spring Boot 项目时，Dependencies 选择了：
1. Spring Boot DevTools
2. Spring Web Starter
3. MySQL Driver
4. JDBC API
5. MyBatis Framework

### 步骤二：mysql 的 docker 镜像使用
1.下载镜像：
```
$ docker pull mysql:8.0.13
```
2.创建一个 mysql 容器
```
$ docker run -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:8.0.13
```
3.查看 mysql 容器的相关信息，会看到容器id、容器name
```
$ docker ps
```
4.进入创建的 mysql 容器的 bash，容器id或name为第3步骤看到的
```
$ docker exec -it yourContainerId或yourContainerName bash
```
5.进入 mysql 命令行，会提示输入 root 用户的密码（即第2步骤配置的：root）
```
$ mysql -uroot -proot
```
6.即可进行 mysql 数据库的管理工作
* 出处：https://hub.docker.com/_/mysql

### 步骤三：数据库管理工作
1.查看有几个数据库
```
mysql> show databases;
```
2.创建一个数据库
```
mysql> create database mysql_test;
```
3.查看数据库 mysql_test 的建库语句
```
mysql> show create database mysql_test\G
```
4.切换到某个数据库
```
mysql> use mysql_test;
```
5.查看数据库相关信息
```
mysql> status;
```
6.创建 users 表
```
mysql> CREATE TABLE `users` (
         `id` bigint(20)  AUTO_INCREMENT    NOT NULL COMMENT '主键id',
         `userName` varchar(32)  DEFAULT '' NOT NULL COMMENT '用户名',
         `passWord` varchar(32)  DEFAULT '' NOT NULL COMMENT '密码',
         `user_sex` varchar(32)  DEFAULT '' NOT NULL COMMENT '性别',
         `nick_name` varchar(32) DEFAULT '' NOT NULL COMMENT '昵称',
         PRIMARY KEY (`id`)
       ) ENGINE=InnoDB AUTO_INCREMENT=28;
```
7.查看 users 表信息
```
mysql> desc users;
```
8.查看 users 表的建表语句
```
mysql> show create table users\G
```
9.查询 users 表
```
mysql> select * from users;
```

### 步骤四：开发过程中的单元测试
1. 执行 src/test/java/tk/mybatis/springboot/controller/UserControllerTest
.java、src/test/java/tk/mybatis/springboot/mapper/UserMapperTest.java 中的测试用例

### 步骤五：启动项目，访问接口
1. 运行：src/main/java/tk/mybatis/springboot/SpringbootApplication.java，或双击：maven->Plugins->spring-boot->spring-boot:run
2. 访问首页及各地址：http://localhost:8080/

### 步骤六：配置 Swagger 接口文档，并在 swagger-ui 上测试接口
1. 参考：http://blog.didispace.com/springbootswagger2/
2. 访问 swagger-ui：http://localhost:8080/swagger-ui.html

### 步骤七：配置 devTools
1. 参考：https://www.cnblogs.com/cag2050/p/7884745.html

### 步骤八：配置缓存
1.在pom.xml中引入cache依赖，添加如下内容：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```
2.在Spring Boot主类 SpringbootApplication.java 中增加 @EnableCaching 注解开启缓存功能
3.在数据访问接口中，增加缓存配置注解，如：
```
@CacheConfig(cacheNames = "users")
public interface UserMapper {

	@Cacheable
	List<User> getAll();
}
```
4.再执行单元测试：src/test/java/tk/mybatis/springboot/mapper/UserMapperTest.java 中的 testQuery，可以在控制台中看到只执行了一次数据库的读取操作；


> 参考：
> 1. Spring Boot(六)：如何优雅的使用 Mybatis(使用博客上的：极简 xml 版本)：http://www.ityouknow.com/springboot/2016/11/06/spring-boot-mybatis.html
> 2. github代码网址(使用博客上的：极简 xml 版本)：https://github.com/ityouknow/spring-boot-examples/tree/master/spring-boot-mybatis/spring
-boot-mybatis
-xml