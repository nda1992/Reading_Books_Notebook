## MySQL基础题目

### 基本操作命令

- 开启/关闭mysql服务

```bash
service mysqld start

/init.d/mysqld start


service mysqld stop

/etc/init.d/mysqld stop
```

- 检测端口是否运行

```bash
netstat -tunlp | grep 3306
```

- 为mysql设置密码或修改密码

```mysql
-- 方法1
mysqladmin -u root -p123456 password 'abcdef'

-- 方法2
update mysql.user set password =password(123456) where user='root' and host='localhost';
flush privileges
```

- MySQL其他操作命令

```mysql
-- 查看当前字符集
show variable like "%charac%";


-- 查看当前版本
select version();

-- 查看当前登录的用户
SELECT user();
+----------------+
| user()         |
+----------------+
| root@localhost |
+----------------+

-- 创建数据库，编码为utf-8
CREATE DATABASE db_name DEFAULT CHARACTER SET utf-8;

-- 创建用户，host：指定该用户在哪个主机上可以登陆，如果是本地用户可用localhost，如果想让该用户可以从任意远程主机登陆，可以使用通配符%

create user 'zhangsan' @ 'host' identified by '123456';

-- 给用户授予权限,privileges：用户的操作权限，如SELECT，INSERT，UPDATE等，如果要授予所的权限则使用ALL		databasename：数据库名			tablename：表名，如果要授予该用户对所有数据库和表的相应操作权限则可用*表示，如*.*
GRANT ALL ON *.* TO 'zhangsan' @ '%';

-- 用户可以授予权限
grant all on databasename.tablename to 'username' @ 'host' with grant option;


-- 查看当前数据库有哪些用户
SELECT user,host from mysql.user;

-- 授权用户zhangsan从192.168.33.19访问数据库
grant all on *.* to zhangsan @ '192.168.33.19' identified by '123456';



```



- 备份、恢复相关

```mysql
-- 在MySQL命令行中备份数据库
system mysqldump -uroot -p123456 -B -x -F --events root>/opt/bak.sql;


```



### 其他内容

- SQL语句分类

```
DDL（数据库定义）：CREATE DROP ALTER

DCL（数据库控制）：GRANT REVOKE COMMIT ROLLBACK

DML（数据库操纵）：SELECT INSERT DELETE UPDATE
```





























