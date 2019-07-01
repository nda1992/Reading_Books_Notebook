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

### 软件包管理

```shell
#ubuntu下查看已经安装的软件包
aptitude

#ubuntu下查看某个特定软件包关联的所有文件的列表
dpkg -L package_name

#ubuntu下从软件库中查找软件包
aptitude search package_name

#ubuntu下从软件库中安装软件包
aptitude install package_name

#red hat系统
#列出已经安装的软件包
yum list installed

#查看某个软件包的详细信息
yum list package_name

#yum安装软件
yum install package_name

#yum更新软件
yum update package_name

#yum卸载软件
yum remove package_name

#显示所有包的依赖关系
yum deplist package_name

#寻找软件库
yum repolist

#源码安装软件包
tar -xzvf package_name
cd package_name
./configure
make
make install
```

### vim编辑器

```shell
h:左移
j:下移
k:上移
l:右移

ctrl+F:下翻一屏数据
pageup:上翻一屏数据
G:移动缓冲区最后一行
gg:移到缓冲区第一行

x:删除当前光标躲在位置的字符
dd:删除当前光标所在行
dw:删除当前光标所在位置的单词
d$:删除当前光标所在位置至行尾的内容
J:删除当前光标所在行行尾的换行符
u:撤销前一命令编辑命令
p:粘贴
y:复制

:s/old/new/g：替换所有old
:%s/old/new/g:替换整个文件中的所有old
:%s/old/new/gc:替换整个文件中的所有old，但在每次出现时提示

```

























