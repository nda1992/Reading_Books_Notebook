# Hive的相关面试题

### 举例使用过UDF？



### Hive的底层运行机制



### Hive与关系型数据的对比（区别）？





### 使用过Hive的哪些内置函数







### 如何调用开发出来的UDF函数(或.py脚本)



### 如何理解Hive中的各种Join？



### 统计报表的HQL编写



### Hive表的默认存储位置？以及默认的文件存储系统？

Hive仓库目录中，表存储为目录，仓库目录由选项hive.metastore.warehouse.dor控制，默认值为/usr/hive/warehouse

Hive默认的存储系统为本地文件系统(fs.default.name设为默认值file:///)



### Hive的执行引擎有哪些？

MapReduce、Tez、Spark.<br>

Tez与Spark都是通用有向无环图引擎，MapReduce的中间作业的输出被存储到HDFS上，而Tez和Spark则不同，它们会根据Hive的规划器的请求，把中间结果写到本地磁盘上，甚至在内存中缓存，从而避免额外的复制开销.<br>

具体使用哪种执行引擎由hive.execution.engine控制，默认值为mr.

### Hive的日志记录保存在哪里？

可以在本地文件系统的\${java.io.tmpdir}/${user.name}/hive.log中找到Hive的错误日志.

### Hive可以运行的服务有哪些？

- cli
- hiveserver2
- beeline
- hwi
- jar
- metastore



### Hive的索引有哪几类？

紧凑索引和位图索引.

### Hive中的表

Hive的表在逻辑上由存储的数据和描述表中数据形式的相关元数据组成，数据一般存放在HDFS中，但它也可以放在其他任何Hadoop文件系统中，包括本地文件系统或S3.<br>

HIve把元数据存放在关系型数据库中.而不是存放在HDFS中.<br>

### Hive中的内部表和外部表的区别？

在Hive中创建表时，默认情况下Hive负责管理数据，即Hive把数据移入它的仓库目录；而另一种是创建外部表，这会让Hive到仓库目录以外的位置访问数据.<br>

对于内部表：

```sql
CREATE TABLE managed_table(name String);
LOAD DATA INPATH '/user/data.txt' INTO TABLE managed_table;
```

上面的HQL表示把文件hdfs://user/data.txt移动到Hive的managed_table表的仓库目录中，即hdfs://user/hive/warehouse/managed_table.<br>

当使用：

```sql
DROP TABLE managed_table;
```

这张表的元数据和数据都会被一起删除.因为最初的LOAD是一个移动操作，而DROP是删除操作.所以数据会彻底消失.<br>

对于外部表（由用户来控制数据的创建和删除）

```sql
CREATE EXTERNAL TABLE external_table(name String)
LOCATION '/user/external_table';		-- 由用户自主决定存储的位置
LOAD DATA INPATH '/user/data.txt' INTO TABLE external_table;
```

使用external关键字后，Hive知道数据并不由自己管理，因此不会把数据移动到自己的仓库目录.

### Hive的分区和桶？它们之间的区别？

使用分区和桶的目的都是为了提高查询的效率.

- 分区：使用分区时（对应HDFS中的一个文件夹），对于限制某个或某些特定的日期查询时，只需要扫描查询范围内分区中的文件.一个表可以从多个维度上进行分区.例如：在根据对日志进行分区外，还需要根据国家对每个分区进行子分区，以加快根据地理位置进行的查询.分区是在创建表时用PARTITIONED BY字句定义的.

```sql
-- 建立分区表
CREATE TABLE logs(ts BIGINT,line STRING)
PARTITIONED BY (dt STRING,country STRING);

-- 向分区表加载数据
LOAD DATA LOCAL INPATH 'input/hive/partitions/file1'
INTO TABLE logs
PARTITION (dt='2019-08-17',country='CH');	-- 表示在2019-08-17目录下还有CH这个目录
```

在文件系统级别，分区只是表目录下嵌套的子目录.<br>

```sql
-- 查询：只会扫描相关的分区.而不会全局扫描
SELECT ts,dt,line
FROM logs
WHERE counttry='CH';
```

- 桶：使用桶的理由：

1. 获得更高的查询效率.（具体而言，连接两个在相同列上划分了桶的表，可以使用map端连接(map-side join)高效实现）.
2. 把表划分为桶使得“取样”更高效.

```sql
-- 创建包含有桶的表
CREATE TABLE bucket_users(id INT,name STRING)
CLUSTERED BY (id) INTO 4 BUCKETS;		--使用id划分桶
```

这里使用id划分桶（Hive对值进行哈希并将结果除以桶的个数取余数）.<br>

要向分桶后的表中填充成员，需要将hive.enforce.bucketing属性设置为true.这样，Hive就知道用表定义中声明的数量来创建桶，最后使用INSERT命令即可：

```sql
INSERT INTO TABLE bucketed_users
SELECT * FROM users;
```

在物理上，每个桶就是表(或分区)目录里的**一个文件**.它的文件名不重要，但是桶$n$是按照字典序排列的第$n$个文件.<br>

事实上，桶对应了MapReduce的输出文件分区，一个作业生产的桶和reduce任务个数相同.<br>

### Hive中导入数据有哪几种方式？

- LOAD DATA:通过把文件复制或移动到表的目录中，从而把数据导入Hive表（或分区）
- INSERT语句将数据从一个Hive表填充到另一个表
- 在建新表时，使用CREATE TABLE ... AS SELECT

### Hive中查询数据的常用操作？

#### 排序和聚集

使用ORDER BY将对输入执行全局排序.而如果不希望是全局排序时，可以使用SORT BY，SORT BY为每个reducer产生一个排序文件.



### Hive中有哪些用户自定义函数？

- UDF：操作作用于单个数据行，且产生一个数据行作为输出
- UDAF：接收多个输入数据行，并产生一个输出数据行（如COUNT、MAX）
- UDTF：操作作用于单个数据行，且产生多个数据行（即一个表）作为输出

一个UDF必须满足两个条件：

1）必须是org.apache.hadoop.hive.al.exec.UDF的子类

2）必须至少实现evaluate()方法















































































































