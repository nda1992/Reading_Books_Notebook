# hive相关笔记
主要介绍了hive的一些主要知识点.<br>

hive是建立在Hadoop上的数据仓库架构，在hive中每个表都有一个对应的存储目录.<br>

**外部表指向已经存在HDFS中存在的数据**

### hive与MySQL

hive使用MySQL保存元数据时，需要对/conf/hive-site.xml文件进行相关配置.

```xml
<property>
    <name>javax.jdo.option.ConnectionURL</name>
    <value>jdbc:mysql://localhost:3306/hive?createDatabaseIfNotExist=true</value>
</property>
<property>
    <name>javax.jdo.option.ConnectionDriverName</name>
    <value>com.mysql.jdbc.Driver</value>
</property>
<property>
    <name>javax.jdo.option.ConnectionUserName</name>
    <value>hive</value>
</property>
<property>
    <name>javax.jdo.option.ConnectionPassword</name>
    <value>123456</value>
</property>
```



1. 创建hive系统用户

```mysql
CREATE USER 'hive' @ '%' IDENTIFIED BY 'hive';
```

2. 授予权限

```mysql
GRANT ALL PRIVILEGES ON *.* TO 'hive' @ '%' WITH GRANT OPTION;
FLUSH PRIVILEGES;	#为了使得远程用户能够访问数据库，需要将/etc/mysql/my.cnf文件中的bind-address一行注释掉
```

需要注意的点：

- 内部表和外部表的概念

  1)内部表由hive自主管理；外部表由HDFS管理.

  2)当删除内部表时，元数据和存储的数据都被删除，而删除外部表时，只会删除元数据，而不会删除(HDFS)实际存储的数据.

- 分区和桶的概念

  分区就是将一个很大的表采用多个表进行存储，从而提高数据查询的性能.因为当表很大时，对整个表进行全局扫面将会消耗很多时间.

  

### 配置hive

在配置hive之前，需要确保目录权限配置正确：将/tmp目录配置成所有用户都有write权限，表所对应的目录的owner必须是hive的所有用户.<br>

**HQL常见操作**<br>

#### 表的创建

1. 创建表(内部表)

```mysql
CREATE TABLE IF NOT EXISTS table_name(
列名1		数据类型,
列名2		数据类型,
    ...
)
row format delimited
fields terminated by '	';
```

内部表的数据保存在core-site.xml文件配置的{/datawarehouse/htable}中

2. 创建表(外部表)

```mysql
CREATE EXTERNAL TABLE table_name(
列名1		数据类型,
列名2		数据类型,
    ...
)
row format delimited
fields terminated by '	'
location '/user/table_name';
```

外部表中的数据保存在HDFS中(location指定的位置)

3. 创建分区表(分区字段不能与表中的字段重名)

```MySQL
CREATE TABLE TABLE table_name(
	id	int,
    name string,
    add	array<string>
)
PARTITIONED BY (pid int)
ROW FORMAT DELIMITED 
FIELDS TERMINATED  BY '	';
```

#### 表的修改

1. 重命名表

```MySQL
ALTER TABLE table_name RENAME TO new_taboe_name;
```

Note:修改表名后，旧的表名没有释放，对旧表的更爱会改变新表的数据.

2. 改变列名

```MySQL
ALTER TABLE table_name CHANGE 
old_col_name col_new_name col_type
[FIRST|AFTER col_name];
```

3. 新增列

```mysql
ALTER TABLE table_name ADD|REPLACE 
COLUMNS (col_name col_type);
```

 ### hive中的分区

hive中的分区是在hive表结构下根据分区的字段设置将数据按目录进行存放，相当于简单的索引功能.

1. 增加分区

```MySQL
ALTER TABLE table_name ADD 
PARTITION(dt='2010-08-08',country='us') 
location '/path/to/you/part008';
PARTITION(dt='2010-08-09',country='china') 
location '/path/to/you/part009';
```

2. 删除分区

```MySQL
ALTER TABLE table_name 
DROP PARTITION(dt='2010-08-08' country='us');
```

### 数据操作

1. 向数据表中加载数据(加载的目标可以是一个表或一个分区)

```MySQL
LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRUTE]	
#使用overwirte时，目标表中的数据将会被删除
INTO TABLE table_name

```













