### Linux重要命令

> 记录了除去一些最基本的命令之外，Linux中重要的命令

- uptime

```
输出结果详解：
14:08:43 up 16 days,  2:07,  1 user,  load average: 0.04, 0.19, 0.24

1：表示系统已经运行16天，1个用户登录过，后面三项分别表示5\10\15分钟的CPU负载，如果单核CPU，那么0~1.0都是正常值
```

- top

```bash
#top命令输出的所有内容分析

tasks: 355 total,   1 running, 286 sleeping,   1 stopped,   0 zombie
##tasks表示进程的数量		running表示当前运行的进程数量		sleep表示当前休眠的进城数量	stopped表示进程执行完成的数量			zombie表示僵尸进程的数量


%Cpu(s):  1.5 us,  0.6 sy,  0.2 ni, 97.6 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
#当前CPU的运行状态，1.5% us表示当前用户占用了1.2%的CPU时间		0.6% sy表示系统进程当前占用了0.6%的CPU时间		ni代表用户进程空间内改变过的优先级的进程占用的CPU百分比		id代表空闲CPU的百分比		wa表示待输入输出的CPU时间百分比


KiB Mem : 16339044 total,   727084 free,  3982100 used, 11629860 buff/cache
#系统的物理内存：总共有多少内存，当前用了多少，还有多少空闲


KiB Swap:  8302588 total,  7154192 free,  1148396 used. 11197960 avail Mem 
#说明的是系统交换空间总共有多少内存，当前用了多少，还有多少空闲

PID  USER      PR  NI    VIRT    RES    SHR  %CPU %MEM     TIME+ COMMAND 

#PID：进程的ID 		USER：进程属主的名字		PR：进程的优先级		NI：进程的nice值（介于-20 到 +19之间，值越大，越谦让）		VIRT：进程占用的虚拟内存总量		RES：进程占用的物理内存总量			SHR：进程和其他进程共享的内存总量			S：进程的状态（D代表可终端的休眠状态，R代表在运行的状态，S代表休眠状态，T代表跟踪状态或停止状态，Z代表僵化状态		%CPU：进程使用的CPU时间比例			%MEM：进程实用的内存占可用内存的比例			TIME+：自进程启动到目前为止的CPU时间总量			COMMAND：进程所对应的命令行名称，也就是启动的程序名。

```

```
#top常用快捷键：

top界面按d键，可以更改刷新时间。默认3秒。

top界面按M键，可以按照内存来进行排序。

top界面按P键，可以按照cpu使用率来排序。

top界面按i键，可以只显示状态为R的进程。

top界面按c键，可以显示进程的完整的名称。

top -s以安全模式启动top界面，可以防止在top界面对进程进行修改操作。

按shift + >键，可以依次按照PID、USER、PR·····来进行排序。

按shift + <键，可以依次按照COMMAND、TIME+、%MEM...来进行排序。

top界面按o键，还可以自定义显示哪些列
```

- ps

```
ps能够给出当前系统中进程的快照

主要参数：
-a	显示除控制进程（session leader）和无终端进程外的所有进程
-A	显示所有进程
-e	此参数的效果和指定-A参数相同
-f	显示完整格式的输出
-u<用户识别码> 	列出属于该用户的进程的状况，也可使用用户名称来指定
-L	显示进程中的线程
-l	显示长列表
a	显示跟任意终端关联的所有进程
u 	采用基于用户的格式显示
x 	显示所有的进程，甚至包括未分配任何终端的进程

--sort order	指定将输出按哪列排序
o format	仅显示由format指定的列
```

- wc

```bash
#wc用于统计文件函数、单词数和字节数等

#	-c		打印字节数
wc -c test.txt

#	-m		打印字符数
wc -m  test.txt

# -l 打印换行数
wc -l  test.txt

#	-w	打印单词数
wc -w  test.txt


# -L	打印最长行的显示宽度
wc -L  test.txt


#查看系统CPU核的数量
grep 'model name' /proc/cpuinfo | wc -l

```

- sort

```bash
#-n	表示按照数值排序（默认是ASCII码排序），-r表示倒排序

sort -nr test.txt

#其它选项

#-u		在输出行中去除重复行
sort -u test.txt

#-t指定分隔符，-k表示需要指定的列
#test.txt:
#	banana:30:5.5
#	apple:10:2.5
#	pear:90:2.3
#	orange:20:3.4
sort -n -k 2 -t: test.txt
```

- uniq

````bash
#去重并统计(要使用sort先进行排序后再统计重复的行数)
uniq -c
#比较下面两个操作的不同之处：

awk '{print $1}' test.txt | uniq -c

awk '{print $1}' test.txt |sort| uniq -c|sort -n


#只显示重复的行
uniq -d

#只显示不重复的各行
uniq -u

````

- cut

```bash
# 用于有条件的对文件内容的查看
# 显示行中的指定部分，删除文件中的指定字段


常用参数：
-b：仅显示行中指定直接范围的内容；

-c：仅显示行中指定范围的字符；

-d：指定字段的分隔符，默认的字段分隔符为“TAB”；

-f：显示指定字段的内容；

-n：与“-b”选项连用，不分割多字节字符；

--complement：补足被选择的字节、字符或字段；

--out-delimiter=<字段分隔符>：指定输出内容是的字段分割符；


#例如
cut -f2,3 -d" " test.txt

```

- netstat

```
用于监控TCP/IP网络的工具，显示路由表、实际的网络连接和每个网络接口设备的状态信息.

netstat用于显示与IP、TCP、UDP和ICMP协议相关的统计数据，一般用于检验本机各端口的网络连接情况.


常用参数
-a (all) 显示所有选项，默认不显示LISTEN相关。
-t (tcp) 仅显示tcp相关选项。
-u (udp) 仅显示udp相关选项。
-n 拒绝显示别名，能显示数字的全部转化成数字。
-l 仅列出有在 Listen (监听) 的服务状态。

-p 显示建立相关链接的程序名
-r 显示路由信息，路由表
-e 显示扩展信息，例如uid等
-s 按各个协议进行统计
-c 每隔一个固定时间，执行该netstat命令。


netstat -nat | awk '{print $6}' | sort | uniq -c
```

- nohup

```
nohup command>/dev/null 2>&1 &

对上述命令的分析：
nohup的作用是不挂断运行某个程序，与终端没有关系，但不是后台运行

nohup command>/dev/null
指的是如果命令不出错，那么就不要输出信息，直接加入到/dev/null中即可

2>&1 
指的是如果出现标准错误（用2表示），那么就stdout（用1表示）输出

&
表示该命令以后台的形式运行，注意与nohup的不同之处
```



- find

```bash
#根据名称查找（-name），支持通配符

find /usr/myshell/ -name '*.txt'

#根据类型查找（-type）
find / -type b       # 块设备文件
find / -type f       # 文件
find / -type d       # 目录
find / -type c       # 字符设备文件
find / -type p       # 管道文件
find / -type l       # 符号链接文件
find / -type s       # socket文件
 
 #根据文件大小进行查找（-size，+表示大于，-表示小于）
 find / -size +1c     # 字节数
 find / -size -1w     # 字（2字节）
 find / -size +1b     # 代表 512 位元组的区块（默认为b）
 find / -size -1k     # 表示 kilo bytes（1024字节）
 find / -size +1M     # 表示兆字节（1048576字节）
 find / -size -1G     # 表示千兆字节（1073741824字节）
 
 
 #查找空文件或空目录(-empty)
find / -empty
 
 #按照链接数查找（-links）
find / -links 3
 
 #根据文件权限进行查找（-perm）
 find / -perm 0644    # 查找权限等于0644的目录或文件
 find / -perm 0644    # 查找权限大于等于0644的目录或文件
 find / -perm 0644    # 查找权限包含0644的目录或文件
# 匹配只有属主为r的文件或目录（精确匹配）
 find / -perm u+r
 
 #根据文件的属主进行查找（-user）
 find / -user "root"  # 查找属主为root的文件或目录
 find / -nouser       # 查找属主不存在的文件或目录
 
 #根据最后访问时间进行查找（-atime，天数）
 # 查找30天前访问的文件或目录
 find / -atime +30
# 查找30天内访问的文件或目录
 find / -atime -30
 
 #按照最后更改时间进行查找（-ctime，天数）
 # 查找30天前更改的文件或目录
 find / -ctime +30
# 查找30天内更改的文件或目录
 find / -ctime -30
 
 #按照最后修改时间进行查找（-mtime，天数）
 # 查找30天前修改的文件或目录
 find / -mtime +30
# 查找30天内修改的文件或目录
 find / -mtime -30
 
 #按照最后访问时间进行查找（-amin，分钟）
 # 查找30分钟前访问的文件或目录
 find / -amin +1
# 查找30分钟内访问的文件或目录
 find / -amin -1

#按照最后更改事件进行查找（-cmin，分钟）
# 查找30分钟前更改的文件或目录
 find / -cmin +1
# 查找30分钟内更改的文件或目录
 find / -cmin -1

#按照最后修改时间进行查找（-mmin，分钟）
# 查找30分钟前修改的文件或目录
 find / -mmin +1
# 查找30分钟内修改的文件或目录
 find / -mmin -1

#从指定目录下最深层的子目录开始查找（-depth）
find ./ -depth

#设置查找目录的最大层级（-maxdepth）
# 只在一层内查找
 find /etc/ -maxdepth 2

#设置查找目录的最小层级（-mindepth）
# 最少查找
 find /etc/ -mindepth 2
```



- whereis

```bash
#whereis命令只能用于程序名的搜索
# 		whereis [-bmsu] [BMS 目录名 -f ] 文件名

#命令行参数
 -b   定位可执行文件。

 -m   定位帮助文件。

 -s   定位源代码文件。

 -u   搜索默认路径下除可执行文件、源代码文件、帮助文件以外的其它文件。

 -B   指定搜索可执行文件的路径。

 -M   指定搜索帮助文件的路径。

 -S   指定搜索源代码文件的路径。
```





















