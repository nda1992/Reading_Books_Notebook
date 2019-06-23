# Hadoop单机版配置

先下载好JDK和Hadoop

[JDK1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Hadoop2.6.5](http://mirror.bit.edu.cn/apache/hadoop/common/hadoop-2.6.5/hadoop-2.6.5.tar.gz)

解压JDK和Hadoop，并配置好环境变量

```shell
export JAVA_HOME=/usr/local/jdk
export PATH=${JAVA_HOME}/bin:$PATH
export HADOOP_HOME=/usr/local/hadoop
export PATH=${HADOOP_HOME}/bin:$PATH
export PATH=${HADOOP_HOME}/sbin:$PATH
#. /etc/profile	使得修改生效
```

配置Hadoop的运行JDK环境

```bash
vi /usr/local/hadoop/etc/hadoop/hadoop-env.sh
JDK_HOME=/usr/local/jdk
```

SSH免密登录

```bash
ssh-keygen -t dsa -P '' -f ~/.ssh/id_dsa  
cat ~/.ssh/id_dsa.pub >> ~/.ssh/authorized_keys  
chmod 0600 ~/.ssh/authorized_keys 
```

修改/usr/local/hadoop/etc/hadoop/core-site.xml

````xml
<configuration>  
    <property>  
        <!-- 根据主机名进行修改，这里的主机名是localhost -->  
        <name>fs.defaultFS</name>  
        <value>hdfs://localhost:9000</value>  
    </property>  
    <property>  
        <name>hadoop.tmp.dir</name>  
        <value>/usr/hadoop/tmp</value>  
    </property>  
</configuration> 
````

修改/usr/local/hadoop/etc/hadoop/hdfs-site.xml 

```xml
<configuration>  
    <property>  
        <name>dfs.name.dir</name>  
        <value>/usr/hadoop/hdfs/name</value>  
        <description>namenode上存储hdfs名字空间元数据 </description>   
    </property>  
  
    <property>  
        <name>dfs.data.dir</name>  
        <value>/usr/hadoop/hdfs/data</value>  
        <description>datanode上数据块的物理存储位置</description>  
    </property>  
    <property>  
        <name>dfs.replication</name>  
        <value>1</value>  
    </property>  
</configuration>  
```

第一次启动HDFS前，需要先格式化

```bash
. /usr/local/hadoop/sbin/hdfs namenodem-format
```

启动HDFS

```bash
. /usr/local/hadoop/sbin/start-dfs.sh
```

使用jps查看所启动的线程

```
namenode
datanode
secondarynamenode
```

在浏览器中查看

```
localhost:50070
```

配置yarn

由于hadoop/etc/hadoop/中没有mapred-site.xml，因此，可以复制，mapred-size.xml.templates

```bash
cp mapred-size.xml.templates mapred-site.xml
```

向文件中添加的内容

```xml
<configuration>  
    <!-- 通知框架MR使用YARN -->  
    <property>  
        <name>mapreduce.framework.name</name>  
        <value>yarn</value>  
    </property>  
</configuration> 
```

配置yarn-site.xml

```xml
<configuration>  
    <!-- reducer取数据的方式是mapreduce_shuffle -->  
    <property>  
        <name>yarn.nodemanager.aux-services</name>  
        <value>mapreduce_shuffle</value>  
    </property>  
</configuration>  
```

启动yarn

```bash
. /usr/local/hadoop/sbin/start-yarn.sh
```

会启动的进程

```
resourcemanager
nodemanager
```





























