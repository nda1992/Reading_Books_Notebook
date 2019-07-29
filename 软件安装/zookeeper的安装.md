# zookeeper的安装

三台虚拟机的主机名分别为：master、slave1、slave2<br>

(1)解压zookeeper到指定目录<br>

(2)修改zoo.cfg

```xml
dataDir=/usr/local/zookeeper/data
<!--在文件末尾加入-->
server.0=master:2888:3888
server.1=slave1:2888:3888
server.2=slave2:2888:3888
```

(3)在zookeeper目录下新建data文件夹<br>

(4)在data目录下新建myid文件<br>

分别在master、slave1、slave2的myid文件下加入0\1\2<br>

(5)启动：zkServer.sh start

(6)查看状态：zkServer.sh status