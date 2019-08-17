# Hadoop相关

## 常见面试题目

面试题包含了编程题和问答题.不划分顺序.

### 统计上行流量、下行流量和总流量





### 统计两个好友之间的共同好友





### 统计两个两两相互关注的好友



### 如何编写从日志文件中上传日志数据到HDFS中(编写shell脚本)？



### 编写WordCount程序



### MapReduce的切片机制



### MapReduce的shuffle原理





### MapReduce的整体流程





### 客户端提交MR程序Job的流程





### MapReduce的设计思路？





### NameNode的安全模式





### Yarn的流程



### Hadoop的分布式缓存机制

分布式缓存是Hadoop提供的一种机制.在job执行前，先将指定的文件分发到task执行的机器上，并有相关机制对cache文件进行管理.分布式缓存可将具体应用相关的、大尺寸的、只读的文件有效地分布放置.<br>

f分布式是Map/Reduce框架提供的功能，能够缓存应用程序所需的文件 （包括文本，档案文件，jar文件等）.<br>

MapRedcue框架在作业所有任务执行之前会把必要的文件拷贝到slave节点上. 它运行高效是因为每个作业的文件只拷贝一次并且为那些没有文档的slave节点缓存文档.



### Hadoop输入分片

Hadoop将MapReduce的输入数据划分为等长的小数据块，称为输入分片.Hadoop为每个分片构建一个map任务，并由该任务来运行用户自定义的map函数从而处理分片中的每条记录.

如果输入分片过小的优缺点：

- 优点：可以获得更好的负载平衡.

- 缺点：管理分片和map任务将会拖延整个作业的执行时间.



### HDSF的构建思路？

- **大文件**
- 流式数据访问

一次写入、多次读取是最高效的访问模式.数据集通过由数据源生成或从数据源复制而来，接着长时间在此数据集上进行各种分析，每次分析都将涉及该数据集的大部分数据甚至全部数据.因此，读取整个数据集的延迟比读取第一条记录的时间延迟更重要.

- 低时间延迟的数据访问

要求低时间延迟数据访问的应用，不适合使用HDFS，HDFS是为高数据吞吐量应用优化的，这可能会以提高时间延迟为代价.而对于低延迟访问需求，HBase是更好的选择.

- 大量的小文件

由于NameNode将文件系统的元数据存储在内存中，因此该文件系统所能存储的文件总数受限于NameNode的内存容量.

- 多用户写入，任意修改文件

HDSF中的文件写入只支持单个写入者，而且写操作总是以“只添加”方式在文件末尾写入数据.不支持多个写入者的操作.也不支持在文件的任意位置进行修改.

### Hadoop为NameNode提供的两种容错机制？

- 备份那些组成文件系统元数据持久状态的文件
- 运行SecondaryNameNode.它不能作为NameNode，只是用于辅助NameNode.即辅助NameNode定期合并编辑日志与命名空间镜像，以防止编辑日志过大.



### HDFS的读数据流程

- 客户端调用FileSystem对象的open()方法打开希望读取的文件.对于HDFS来说，该对象是DistributedFileSystem的一个实例.
- DistributedFileSystem通过使用远程过程调用（RPC）来调用NameNode，以确定文件起始块的位置.
- 对于每个块，NameNode返回存有该块副本的DataNode地址，这些DataNote根据它们与客户端的距离来排序，如果该客户端本身就是一个DataNote，那么该客户端将会从保存有相应数据块副本的本地DataNote读取数据.
- DistributedFileSystem类返回一个FSDataInputStream对象给客户端以便读取数据.FSDataInputStream类转而封装DFSInputStream对象，该对象管理着DataNote和NameNode的IO.
- 客户端对这个输入流调用read()方法，存储者文件起始几个块的DataNote地址的DFSInputStream随即连接距离最近的文件中的第一个块所在的DataNote，通过对数据流反复调用read()方法，可以将数据从DataNote传输到客户端.
- 到达块的末端时，DFSInputStream关闭与该DataNote的连接，然后寻找下一个块的最佳DataNote.

### HDFS的写数据流程



### map端如何使用join解决数据倾斜？

https://www.cnblogs.com/yaboya/p/9246131.html

























### 