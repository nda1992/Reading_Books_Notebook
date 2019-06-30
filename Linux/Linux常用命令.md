# Linux

### Linux中的一些比较容易忘记的命令

- df：常看各个目录挂载设备的存储容量使用情况

- du:某个目录下各个文件的大小

```bash
du sh * | sort -nr	#列出该目录下哪个文件占用的空间最多，-n表示排序
```

- 搜索数据(在大文件中找一行数据)，grep是最长的使用的工具

```shell
#grep的格式
grep [options] pattern [file]

#查找含有指定单词的行
grep three file1
```

- 压缩数据

bzip2

```shell
bzip2	#压缩文件
bzcat	#显示压缩文件的内容
bunzip2	#解压压缩后的.bz2文件
```

gzip

```shell
gzip	#压缩文件
gzcat	#查看压缩过的文本文件内容
gunzip	#解压文件
```

zip

```shell
zip		#创建压缩文件，包含指定的文件和目录
zipcloak	#创建一个加密的压缩文件，包含指定的文件和目录
unzip	#从压缩过的zip文件中提取目录和文件
```

- 查看进程

```shell
ps -ef	#查看系统上的所有进程
```

- 查看CPU使用率

```shell
top
```

### 环境变量





### 文件权限

- 格式1：

-rw-r--r--

- 格式2：

drwxr-xr-x

```
-表示文件
d表示目录
l表示链接
c表示字符型设备
b表示块设备
n表示网络设备
r表示对象可读
w表示对象可写
x代表对象可执行
```

3组三字码分别表示对应对象的3个安全级别：

对象属主

对象属组

系统其他用户

chown用于改变文件的属主

````shell
chown user newfile	#可用登录名或UID来指定文件的新属主
````

chgrp更改文件或目录的默认组

```shell
chgrp shared newfile
```

### 用户和用户组

```shell
useradd -m test	#创建新用户，并检查新用户的HOME目录
#而参数-g表示用户登录组的GID或组名

#创建新组
groupadd shared

#可以使用usermod添加用户到该组
usermod -G shared test

#修改组
group -n sharing shared
```

























