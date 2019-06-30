# 常用SQL操作

包含了MySQL中常用的SQL语句的基本操作<br>

### 数据库的定义SQL

- 创建数据库

```mysql
CREATE DATABASE IF NOT EXISTS db_name DEFAULT CHARACTER SET charset_name;
```

- 使用数据库

```mysql
USE db_name;

#查看数据库
SHOW DATABASES SCHEMAS;
```

- 修改数据库

```mysql
ALTER DATABASE db_name
DEFAULT CHARACTER SET charset_name;
```

- 删除数据库

```mysql
DROP DATABASE SCHEMA IF EXISTS db_name;
```

### MySQL中的数据类型

- 数值型

```mysql
BIT(M)	(1~64)
TINYINT(M)	(-128~127)
BOOL/BOOLEAN
SMALLINT(M)	(-32768~32767/0~65535)
INT(M)
INTEGER(M)
BIGINT(M)
DOUBLE(M,D)	#M是标书总位数，D是小数点后面的位数
DECIMAL(M,D)
```

- 日期和时间类型

```mysql
DATE	#YYYY-MM-DD
DATETIME	#YYYY-MM-DD HH:MM:SS
TIMESTAMP	#YYYY-MM-DD HH:MM:SS
TIME	#HH:MM:SS
YEAR	#YYYY
```

- 字符串类型

```mysql
CHAR(M)		#固定长度字符
VARCHAR(M)	#可变长字符
TINYTEXT
TEXT(M)	
```

- 创建表

```mysql
CREATE TABLE db_name.tb_name(
	col1	col_type	默认值,
    col2	col_tpye,	默认值
    ...,
    表级完整性约束条件
)ENGINE=引擎类型;

#	example		#
CREATE TABLE tb_student(
	studentNo	CHAR(10)	NOT NULL UNIQUE,
    studentName	VARCHAR(20) NOT NULL,
    sex CHAR(2),
    birthday DATE,
    native	VARCHAR(20),
    nation	VARCHAR(10),
    classNo	CHAR(6)
)ENGINE=InnoDB;	

#Note:完整约束性条件
#实体完整性约束（PRIMARY KEY，UNIQUE）
#参照完整性约束（FOREIGN KEY）
#用户自定义完整性约束（NOT NULL，DEFAULT，CHECK）
```

*每个表只能定义一个AUTO_INCREAMENT列，并且必须在该列上定义主键约束(PRIMARY KEY)或候选键约束(UNIQUE)*<br>

*DEFAULT可以为某个属性数值默认值*

- 查看表

```mysql
SHOW TABLES FROM db_name;
```

- 查看表结构

```mysql
DESC tb_name;
```

- 修改表

```mysql
#添加字段
ALTER TABLE tb_name ADD COLUMN 新字段名 数据类型 约束条件 FIRST|AFTER 已有字段名;

#	example		#
ALTER TABLE db_school.db_student
ADD COLUMN id INT NOT NULL UNIQUE AUTO_INCREAMENT FIRST;

ALTER TABLE db_school.db_student
ADD COLUMN department VARCHAR(16) DEFAULT '信息学院' AFTER nation;
```

- 修改字段

```mysql
CHANGE	#同时修改表中指定列的名称和字段类型
ALTER TABLE tb_name CHANGE[COLUMN] 原字段名 新字段名 数据类型 [约束条件];

ALTER	#修改和删除表中指定列的默认值
ALTER TABLE tb_name ALTER[COLUMN] 字段名 [SET|DROP] DEFAULT;

MODIFY	#只会修改列的数据类型，不会干涉列名
ALTER TABLE tb_name MODIFY[COLUMN]字段名 数据类型[约束条件] [FIRST|AFTER 已有字段];
```

- 删除字段

```mysql
ALTER TABLE tb_name DROP [COLUMN] 字段名;
```

- 重命名表

```mysql
ALTER TABLE 原表名 RENAME TO 新表名;
```

- 数据的约束完整性

```mysql

```



