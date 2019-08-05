# Hadoop相关

## HDFS原理

### HDFS的基本内容

HDFS集群分为NameNode、DataNode和Secondary NameNode<br>

NameNode负责管理整个文件系统的元数据<br>

DataNode负责管理用户的数据块<br>

文件会按照固定的大小切成若干块后分布式存储到若干台DataNode上<br>

每个文件块可以有多个副本，并存放在不同的DataNode上<br>

DataNode会定期向NameNode汇报自身所保存的文件block信息，而NameNode则会负责保持文件的副本数量<br>

HDFS的内部工作机制对客户端保持透明，客户端请求访问HDFS是通过NameNode申请来进行<br>

### HDFS的读写流程

![](/usr/2019/读书笔记/images/HDFS写流程.png)



































