# hive的安装

我这里一共是三台虚拟机.分别为master、slave1、slave2.

- 安装Hadoop

(1)解压到指定目录后，配置如下：

core-site.xml

```xml
<configuration>
<property>
    <name>fs.default.name</name>
    <value>hdfs://master:9000</value>
</property>
</configuration>
```

yarn-site.xml

```xml
<configuration>

<!-- Site specific YARN configuration properties -->
    <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>master</value>
    </property>

    <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
    </property>
</configuration>
```

mapred-site.xml

```xml
<configuration>
    <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
    </property>
</configuration>
```

(2)在hadoop-env.sh文件中加入JDK路径.<br>

(3)在slaves文件中加入slave1和slave2.<br>

(4)将Hadoop整个文件夹拷贝到slave1和slave2<br>

(5)格式化：hdfs namenode -format<br>

(6)启动hdfs和yarn：

```shell
./sbin/start-dfs.sh
./sbin/start-yarn.sh
```

这样就启动好Hadoop<br>

- 安装hive

(1)解压到指定目录，修改hive-site.xml如下：

```xml
<property>
<!-- 元数据库的链接地址 mysql -->
   <name>javax.jdo.option.ConnectionURL</name>  
   <value>jdbc:mysql://master:3306/hive?createDatabaseIfNotExist=true</value>
</property>

<property>
<!-- 指定mysql驱动 -->
   <name>javax.jdo.option.ConnectionDriverName</name>
   <value>com.mysql.jdbc.Driver</value>
</property>

<property>
<!-- 指定mysql驱动 -->
   <name>javax.jdo.option.ConnectionDriverName</name>
   <value>com.mysql.jdbc.Driver</value>
</property>

<property>
<!-- 指定mysql密码 请输入自己的MySQL连接密码 -->                     
    <name>javax.jdo.option.ConnectionPassword</name>
    <value>password</value>
</property>
```

**几个可能报错的地方**

| 问题                            | 抛出的异常                                                   | 解决                                                         |
| ------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| jline的jar包版本问题            | java.lang.IncompatibleClassChangeError: Found class jline.Terminal, but interface was expected... | 将hive/lib下的jline包拷贝到/hadoop/share/hadoop/yarn/lib目录下，替换原来的jline包，重新启动hive |
| system:java.io.tmpdir配置项问题 | Exception in thread "main" java.lang.RuntimeException: java.lang.IllegalArgumentException: java.net.URISyntaxException: Relative path in absolute URI: ${system:java.io.tmpdir%7D/$%7Bsystem:user.name%7D...1. | 1.在hive下创建一个tmp目录；2.将system:java.io.tmpdir配置项中所有的value更换为/usr/local/hive/tmp |
| 出现Hadoop拒绝连接              |                                                              | 需要确保Hadoop的HDFS和Yarn已经启动                           |











































