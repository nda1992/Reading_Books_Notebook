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
#外键是一个表中的一个或一组属性，它不是这个表的主键，但它是另外一个表的主键.定义外键后，不允许删除外键引用的另一个表中具有关联关系的记录
#外键所属的表称作参照关系，相关联的主键所在的表称为被参照关系
CREATE TABLE db_school.tb_student(
	studentNo CHAR(10),
    studentName VARCHAR(20) NOT NULL,
    sex CHAR(2) NOT NULL,
    birthday DATE,
    native VARCHAR(20),
    nation VARCHAR(10),
    classNo CHAR(6),
    CONSTRAINT PK_student PRIMARY KEY(studentNo),	#主键
    CONSTRAINT PK_student FOREIGN KEY(classNo) REFERENCES tb_class (classNo)	#外键与另一个表的主键(classNo字段)相关联
    ON UPDATE RESTRICT	#
    ON DELETE CASCADE	#从被参照表中删除或修改记录时，自动删除或修改参照表中匹配的记录
)ENGINE=InnoDB;
```

- 删除约束

```mysql
#删除外键约束
ALTER TABLE tb_name DROP FOREIGN KEY PK_student;

#删除主键约束
ALTER TABLE tb_name DROP PRIMARY KEY;
```

- 添加约束

```mysql
#添加主键约束
ALTER TABLE tb_name ADD CONSTRAINT <约束名> PRIMARY KEY (主键字段);

#添加外键约束
ALTER TABLE tb_name ADD CONSTRAINT <约束名> FOREIGN KEY (外键字段名) REFERENCES 被参照表(主键字段名);
```



### SQL查询语句

- SELECT语句

```mysql
SELECT ALL DISTINCT c1,c2,...
FROM tb_name/view_name 
WHERE 条件表达式
GROUP BY col HAVING 条件表达式
ORDER BY col ASC|DESC
LIMIT m,n			#m:偏移量，n:行数

#GROUP BY：将结果集按指定字段分组
#HAVING:用于指定分组结果集的过滤条件
```

WHERE字句中常用的查询条件

| 查询条件   | 操作符                       |
| ---------- | ---------------------------- |
| 比较       | =,<>,!=,<,<=,>,>=,!<,!>      |
| 范围       | BETWEEN AND ,NOT BETWEEN AND |
| 集合       | IN ,NOT IN                   |
| 字符串匹配 | LIKE,NOT LIKE                |
| 空值       | IS NULL,IS NOT NULL          |
| 多重条件   | AND,OR                       |



```mysql
#一些查询语句的例子

SELECT studentName,birthday
FROM tb_student
WHERE birthday NOT BETWEEN '1997-01-01' AND '1997-12-310';


SELECT *
FROM tb_student
WHERE native IN ('北京','上海');


SELECT * 
FROM tb_student
WHERE studentName LIKE '王%';	#所有姓王的学生


#使用ORDER BY作升序或降序
SELECT studentName,native,nation
FROM tb_student
ORDER BY studentName;
```

*使用聚合函数*

| 函数名      | 说明                     |
| ----------- | ------------------------ |
| COUNT(*)    | 统计数据表中的记录数     |
| COUNT(列名) | 统计表中的一列中值的个数 |
| MAX(列名)   | 求表的一列值中的最大值   |
| MIN(列名)   | 求表的一列值中的最小值   |
| SUM(列名)   | 求表的一列值中的和       |
| AVG(列名)   | 求表的一列值中的最平均值 |

*分组聚合查询*

**GROUP BY**对查询结果按字段列表进行分组，字段值相等的记录分为一组，指定用于分组的字段列表可以是一列，也可以是多列(用逗号分割)，HAVING字句对分组的结果进行过滤，返回满足条件的组

```mysql
SELECT studentNo,COUNT(*)sourse_num
FROM tb_score
WHERE score>80
GROUP BY studentNo
HAVING COUNT(*)>=2;

#WHERE:字句作用于基本表或视图
#HAVING:是基于分组的聚合值
#HAVING中可以包含聚合函数，但WHERE中不可以；WHERE在数据分组前进行过滤，HAVING在数据分组后过滤
```

**连接查询**

包括交叉连接、内连接和外连接

*内连接*

```mysql
SELECT col1,col2,...
FROM table1，table2
WHERE 连接条件

SELECT col1,col2,...
FROM table1 INNER JOIN table2
ON 连接条件
[WHERE 过滤条件]


##	example	##
SELECT tb_student.*,tb_score.*
FROM tb_student,tb_score
WHERE tb_student.studentNo=tb_score.studentNo;

#或者是
SELECT tb_student.*,tb_score.*
FROM tb_student INNER JOIN tb_score
ON tb_student.studentNo=tb_score.studentNo;
```

### 子查询

可将查询语句嵌套在另一个查询语句的WHERE或HAING中，WHERE称为内层查询或子查询，HAVING称为外层查询或父查询.<br>

**在SELECT语句中，先计算子查询，然后将子查询的结果作为父查询的过滤条件.**

```MySQL
#带IN字句的
SELECT studentName
FROM tb_student
WHERE tb_student.studentNo IN
(SELECT DISTINCT tb_score.studentNo FROM tb_score);
```













































































