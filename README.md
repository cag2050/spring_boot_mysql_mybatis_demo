### Spring Boot 使用 MyBatis 例子

* 使用 Spring Initializr 创建此 Spring Boot 项目时，Dependencies 选择了：
1. Spring Boot DevTools
2. Spring Web Starter
3. MySQL Driver
4. JDBC API
5. MyBatis Framework

* maven 构建

### mysql 的 docker 镜像使用
1.下载镜像：
```
$ docker pull mysql:8.0.13
```
2.创建一个 mysql 容器
```
$ docker run --name mysql_test -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.13
```
3.查看 mysql 容器的相关信息
```
$ docker ps
```
4.进入创建的 mysql 容器的 bash，容器名字为第2步骤配置的：mysql_test
```
$ docker exec -it mysql_test bash
```
5.进入 mysql 命令行，会提示输入 root 用户的密码（即第2步骤配置的：root）
```
$ mysql -u root -p
```
6.即可进行 mysql 数据库的管理工作
* 出处：https://hub.docker.com/_/mysql

### 数据库管理工作
1.查看有几个数据库
```
mysql> show databases;
```
2.创建一个数据库
```
mysql> create database mysql_test;
```
3.切换到某个数据库
```
mysql> use mysql_test;
```
4.查看数据库相关信息
```
mysql> status;
```
5.创建 users 表
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
6.查看 users 表信息
```
mysql> desc users;
```
7.查看 users 表的建表语句
```
mysql> show create table users\G
```
8.查询 users 表
```
mysql> select * from users;
```


* 参考：http://www.ityouknow.com/springboot/2016/11/06/spring-boot-mybatis.html