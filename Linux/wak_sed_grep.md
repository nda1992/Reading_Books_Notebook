# awk_sed_grep

awk、sed和grep的作用：

- awk：适合格式化文本，对文本进行较复杂的处理
- sed：适合编辑匹配到的文本
- grep：适合淡村的查找和匹配文本

## awk

awk用于文本格式化.可以用来处理表格等格式的文件.

awk支持判断、数组、循环等操作.

awk的语法格式

```shell
awk [option] 'pattern{Action}' file
# action称为动作，如print或printf
#pattern为所使用的模式
```

实际操作

```shell
#如df.log的文件格式为：
文件系统           1K-块      已用      可用 已用% 挂载点
udev             4018784         0   4018784    0% /dev
tmpfs             808176      3744    804432    1% /run
/dev/sda2      237313720  81699576 143536220   37% /
tmpfs            4040876     87196   3953680    3% /dev/shm
tmpfs               5120         4      5116    1% /run/lock
tmpfs            4040876         0   4040876    0% /sys/fs/cgroup
/dev/sda1         523248      7476    515772    2% /boot/efi
tmpfs             808172        16    808156    1% /run/user/125
tmpfs             808172        68    808104    1% /run/user/0
/dev/sdb1      976727036 593684700 383042336   61% /media/root/My Passport
/dev/sdc4        7849728   5315152   2534576   68% /media/root/GRMCENVOL_C

#提取所有的列
awk '{print}' df.log

#提取第3列
awk '{print $3}' df.log

#对于待处理的文本，awk是一行接着一行来进行处理的.
#它会将每一行按照分隔符分成多个字段.如$1表示第一个字段等.

#指定输出多个字段
awk '{print $1,$3,$5}' df.log
```

### 常见情况说明

- awk中的$0表示整行
- $NF表示最后一个字段，而倒数第二个字段也可以为\$(NF-1)

```shell
#使用awk可以添加用户的字段

cat text1.txt
hello world
world hello
spark java
java python
hadoop hive hbase zookeeper
scala ruby javascript
zookeeper

awk '{print $1,$2,"language"}' text1.txt
hello world language
world hello language
spark java language
java python language
hadoop hive language
scala ruby language
zookeeper  language

#将每一列将使用指定的字符串拼接
 awk '{print "lan1:" $1,"lan2:"$2}' text1.txt
 lan1:hello lan2:world
lan1:world lan2:hello
lan1:spark lan2:java
lan1:java lan2:python
lan1:hadoop lan2:hive
lan1:scala lan2:ruby
lan1:zookeeper lan2:
```

### awk的pattern(模式)

awk的两种特殊的模式是：BEGIN和END

- BEGIN指定了处理文本之前需要执行的操作

- END指定了处理完所有行之后需要执行的操作

```shell
#直接先执行BEGIN模式中的内容，可以不用指定文件
awk 'BEGIN{print "lan1","lan2"}'

#先执行BEGIN模式，然后再执行BEGIN之后的操作
awk 'BEGIN{print "lan1","lan2"} {print $1,$2}' text1.txt
lan1 lan2
hello world
world hello
spark java
java python
hadoop hive
scala ruby
zookeeper 

#向执行END之前的操作，再执行END模式
awk '{print $1,$2} END{print "lan1","lan2"}' text1.txt
hello world
world hello
spark java
java python
hadoop hive
scala ruby
zookeeper 
lan1 lan2
```

### awk输入分隔符

awk处理文本切分成多个字段时，默认使用空格进行切分.如果一行文本中没有空格，可以使用特定得到文本或符号作为输入分隔符.

```shell
cat text2.txt 
abc#def#666
fhg#ijk#777

#使用-F选项，指定#为分隔符
awk -F# '{print $1,$2}' text2.txt
abc def
fhg ijk
```

### awk输出分隔符

```shell
#awk的默认输出分隔符是空格，可以使用-v OFS来指定输出分隔符

cat text1.txt
hello world
world hello
spark java
java python
hadoop hive hbase zookeeper
scala ruby javascript
zookeeper

awk -v OFS="***" '{print $1,$2}' text1.txt
hello***world
world***hello
spark***java
java***python
hadoop***hive
scala***ruby
zookeeper***
```

```shell
awk '{print $1$2}'		#表示每行分割后，将第一列和第二列连接在一起输出

awk '{print $1,$2}'		#表示每行分割后，将第一列和第二列连接以输出分隔符分开后显示
```

### awk的一些常用内置变量

| 内置变量 | 作用                                 |
| -------- | ------------------------------------ |
| FS       | 输入字段分隔符，默认是空格           |
| OFS      | 输出字段分隔符，默认是空格           |
| RS       | 输入记录分隔符：指定输入时的分隔符   |
| ORS      | 输出时用指定的符号代替换行符         |
| NF       | 当前行的字段个数，即字段数量         |
| NR       | 行号，当前处理的文本行的行号         |
| FNR      | 各文件分别技术的行号                 |
| FILENAME | 当前文件名                           |
| ARGC     | 命令行参数个数                       |
| ARGV     | 数组，保存的是命令行所给定的各个参数 |

#### 具体操作

```shell
cat text1.txt
hello world
world hello
spark java
java python
hadoop hive hbase zookeeper
scala ruby javascript
zookeeper

awk '{print NR,NF}' text1.txt
1 2
2 2
3 2
4 2
5 4
6 3
7 1

awk '{print NR,$0}' text1.txt
1 hello world
2 world hello
3 spark java
4 java python
5 hadoop hive hbase zookeeper
6 scala ruby javascript
7 zookeeper

#使用FNR处理多个文件时，处理的每个文件的行号都是从新开始计数
awk '{print FNR,$0}' text1.txt text2.txt
1 hello world
2 world hello
3 spark java
4 java python
5 hadoop hive hbase zookeeper
6 scala ruby javascript
7 zookeeper
1 abc#def#666
2 fhg#ijk#777

#使用-v RS指定每次遇到一个空格就为新的一行
awk -v RS=" " '{print NR,$0}' text1.txt
1 hello
2 world
world
3 hello
spark
4 java
java
5 python
hadoop
6 hive
7 hbase
8 zookeeper
scala
9 ruby
10 javascript
zookeeper

#自定义变量
awk -v var="666" 'BEGIN{print var}'
666
```

### awk的格式化(printf)

```shell
#输出第一列，并以使用\n进行换行
awk '{printf "%s\n",$1}' text1.txt
hello
world
spark
java
hadoop
scala
zookeeper

awk '{printf "first col:%s second col:%s\n",$1,$2}' text1.txt
first col:hello second col:world
first col:world second col:hello
first col:spark second col:java
first col:java second col:python
first col:hadoop second col:hive
first col:scala second col:ruby
first col:zookeeper second col:
```

## sed

sed是对输入的某一行执行sed命令.用时sed还可以配合正则表达式对数据进行处理.

处理时，把当前处理的行存储在临时缓冲区中，称为”模式空间”（ oattern space），接看用sed命令处理缓冲区中的内容，处理成后，把缓冲区的内容送往屏幕显示

执行格式：sed script INPUTFILE...



















