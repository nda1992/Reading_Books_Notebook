# Hadoop看书记录

## Hadoop与分布式开发

通常所说的分布式系统其实就是分布式软件系统，即支持分布式处理的软件系统。它们在通信网络互联的多处理机体系结构上执行任务的系统，包括分布式操作系统、分布式程序设计和编译系统、分布式文件系统和分布式数据库系统.<br>

Hadoop上并行应用程序的开发是基于mapreduce编程模型的.mapreduce编程模型的原理是：利用一个输入key/value对集合产生一个输出的key/value对集合.

**用户自定义的map函数接收一个输入的key/value对，然后产生一个中间key/value对的集合，mapreduce把所有具有相同key值的value集合在一起，然后传递给reduce函数.用于自定义的reduce函数接收key和相关的value集合，reduce函数合并这些value值，形成一个较小的value集合**

### 1.数据分布存储

### 2.分布式并行计算

### 3.本地计算

### 4.任务粒度

### 5.数据分割

### 6.数据合并

### 7.Reduce

## Mapreduce任务优化

计算模型的优化主要集中在两个方面：1）计算性能；2）IO操作<br>

主要从以下6个方面来理解：<br>

- 任务调度
- 数据预处理和InputSplit的大小
- Map和Reduce的数量
- Combine函数
- 压缩
- 自定义comparator





















