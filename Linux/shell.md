# shell脚本

主要记录了一些shell脚本的基础内容

- 环境变量

```shell
#!/bin/bash
echo HOME:$JAVA_HOME
```

```shell
#使用$来进行取值
#\$输出$符号
echo "The cost is \$15"
```

- 用户变量

用户变量允许临时存储数据并在整个脚本中使用，shell脚本中的变量会一直保持着值，但在shell脚本完成时删除.shell脚本会自动决定变量值的数据类型.

````shell
var1=15	#值通过等号赋给用户变量，在变量、等号和值之间不能出现空格
var2=-10

#引用变量时需要$，而引用变量来对其进行复制时则不需要$
value1=10
value2=$value1
echo $value2	#输出10
value2=value1
echo $value2	#输出value1
````

- 反引号

" ` "的作用是将shell命令的输出赋给变量

```shell
#!/bin/bash
today=`date +%y%m%d`
ls /usr/bin -al > log.$today
```

- 重定向输入和输出

用于保存某个命令的输出而非显示在显示器上.

```shell
#输出重定向
date > test	#">"表示覆盖文件内容
date >> test #">>"表示在已有文件上追加内容

#输入重定向
wc < test #将test文件的内容重定向输入到wc命令中，从而统计test中的行数、词数和字节数

#内联重定向
command << marker
```

- 管道

用于将一个命令的输出作为另一个命令的输入

```shell
rpm -qa | sort	#排序的方式列出已经安装的rpm包

rpm -qa | sort > rpm.list	#使用重定向输出到文件中
```

- 执行数学运算

将一个数学运算结果赋给某个变量时，可以使用($[ operation ])

```shell
var=$[ 2+5 ]
echo $var	#output:7

var1=15
var2=25
var3=$[ $var1*$[$var2-$var1] ]
echo $var3	#output:150

#Note:bash shell仅仅支持整数运算

#使用bc计算浮点数
var1=50
var2=30
var3=`echo "scale=4; $var1/$var2" | bc`
echo $var3		#output:1.6666

#使用EOF进行内联重定向
var1=10.22
var2=2.55
var3=`bc << EOF
scale=4
a1=( $var1*$var2 )
b1=( $var1+$var2 )
a1+b1
EOF
`
echo $var3	#output:38.8310
```

- 使用退出状态码退出脚本

```
”$?“用来保存上个执行命令的退出状态码
成功执行的命令的退出状态码是0

Linux的一些退出状态码
0	命令成功结束
1	通用未知错误
2 	误用shell命令
126	命令不可执行
127	没有找到命令
128	无效退出参数
128+x	Linux信号x的严重错误
130	命令通过Ctrl+C终止
255	退出状态码越界
```

### 常用的结构化命令

- if语句

```shell
if command
then
command
fi

if command
then 
command
else
command
fi

if command
then 
command
elif
command
fi
```

- test命令

test命令可以判断3类条件：数值比较、字符串比较、文件比较

```shell
#如果test命令中列出的条件成立，test命令就会退出并返回退出状态码0，如果不成立，退出并返回退出状态码1
if test condition
then
	command
fi


if [ condition ]	#[]中左右加一个空格
then
	command
fi
```

*test数值比较*

|   比较    |  描述   |
| :-------: | :-----: |
| n1 -eq n2 | n1==n2? |
| n1 -ge n2 | n1>=n2? |
| n1 -gt n2 | n1>n2?  |
| n1 -le n2 | n1<=n2? |
| n1 -lt n2 | n1<n2?  |
| n1 -ne n2 | n1!=n2? |

*test字符串比较*

| 比较         | 描述                 |
| ------------ | -------------------- |
| str1 = str2  | str1与str2是否相同   |
| str1 != str2 | str1与str2是否不相同 |
| str1 < str2  | str1<str2?           |
| str1 > str2  | str1>str2?           |
| -n str1      | str1长度是否非0      |
| -z str1      | str1长度是否为0      |

```shell
#!/bin/bash
var1=baseball
var2=hockey
if [ $var1 \> $var2 ]	#要对>进行转义,否则为重定向符号
then
	echo "$var1 is greater than $vae2"
else
	echo "$var1 is less than $var2"
fi
```

```shell
#!/bin/bash
var1=baseball
var2=hockey
var3=''
if [ -n "$var1" ]
then
	echo "the string '$var1' is not empty"
else
	echo "the string '$var1' is empty"
fi

if [ -z "$var3"]
then
	echo "the string '$var3' is empty"
else
	echo "the string '$var3' is not empty"
fi
```

*test文件比较*<br>

test可以测试Linux文件系统上文件和目录的状态

| 比较            | 描述                                 |
| --------------- | ------------------------------------ |
| -d file         | file是否存在并是一个目录             |
| -e file         | file是否存在                         |
| -f file         | file是否存在并是一个文件             |
| -r file         | file是否存在并可读                   |
| -s file         | file是否存在并非空                   |
| -w file         | file是否存在并可写                   |
| -x file         | file是否存在并可执行                 |
| -o file         | file是否存在并属当前用户所有         |
| -G file         | file是否存在并且默认组与当前用户相同 |
| file1 -nt file2 | file是否比file2新                    |
| file1 -ot file2 | file是否比file2新                    |

*复合条件测试*

```shell
[ condition1 ] && [ condition2 ]
[ condition1 ] || [ condition2 ]
```

*if-then 的高级特性*<br>

用于数学表达式的双尖括号<br>

用于高级字符串处理功能的双方括号<br>

```shell
(( expr ))	#双尖括号，expr是任意的数学赋值或比较表达式
[[ expr ]]	#双方括号，可以定义正则表达式来匹配字符串

#case命令
#!/bin/bash
case $USER in
root|aaa)
	echo "hello,$USER";;
testing)
	echo "hello, $USER";;
jes)
	echo "hell,jes";;
*)
	echo "SORRY";;
esac
```

*for循环*

```shell
for var in list
do
	command
done
```

*while循环*

```shell
while test command
do
	other command
done

#!/bin/bash
var=10
while [ $var -gt 0 ]
do
	echo $var
	var=$[ $var-1 ]
done
```

*until命令*

```shell
until test command
do
	other command
done

#!/bin/bash
var=100
until [ $var -eq 0 ]
do
	echo $var
	var=$[ $var-25 ]
done
```

*重定向循环的输出*

```shell
#!/bin/bash
var=100
until [ $var -eq 0 ]
do
	echo $var
	var=$[ $var-25 ]
done > /home/aaa/Linux_shell/text.txt
```

*管接给另外一个命令*

````shell
#!/bin/bash
for i in b c d e a
do
	echo $i
done | sort
````

### 处理用户输入

将**位置参数**的特殊变量分配给命令行输入的所有参数.位置参数变量的是标准数字:$0是程序名，\$1是第一个参数，\$2是第二个参数，以此类推.<br>

*使用basename获取程序名*

```shell
#!/bin/bash
name=`basename $0`
echo $name
```

S#可以获取脚本运行时有多少个命令行参数<br>

使用*shift*命令可以移动参数(在不知道有多少个输入参数时可以使用)

```shell
#!/bin/bash
count=1
while [ -n "$1" ]
do
	echo "#$count=$1"
	count=$[$count+1]
	shift
done
```

*获取用户输入*<br>

read命令接受从标准输入或另一个文件描述符的输入.<br>

```shell
#!/bin/bash

echo -n "Enter your name:"	#-n表示移除字符串末尾的换行符
read name
echo "hello $name"

read -p "enter your age: " age	#-p表示read命令指定的提示符
echo "$name your age is $age"

#read命令行可以不指定变量，则read命令会将收到的任何数据保存在特殊的环境变量REPLY中

#可以使用-t指定计时器，防止脚本使用read超时
#!/bin/bash

if read -t 5 -p "enter your name: " name
then 
	echo "hello $name"
else
	echo "sorry.too slow"
fi
```

*从文件中读取*

```shell
#!/bin/bash

count=1
cat test1.sh | while read line	#while循环会通过read读取文件中的行，直到read以非零退出状态码退出
do
	echo "linle $count:$line"
	count=$[ $count+1 ]
done
echo "finished"
```

### 输入和输出

Linux中用文件描述符表示每个文件对象.每个过程一次最多有9个文件描述符.<br>

最早的3个文件描述符

| 文件描述符 | 缩写   | 描述     |
| ---------- | ------ | -------- |
| 0          | STDIN  | 标准输入 |
| 1          | STDOUT | 标准输出 |
| 2          | STDERR | 标准错误 |

可以使用它们将shell的输入和输出定向到相应的位置.

*重定向错误*

```shell
ls -al badfile 2> test	#文件描述符值放在重定向符号前，该值必须紧跟在重定向符号前

ls -al test1 test2 badtest &> test3		#使用"&>"将STDERR和STDOUT的输出重定向到同一个输出文件
```

*脚本中定向输出*<br>

在脚本中临时重定向输出.<br>

```shell
echo "this is an error msg"	>&2		#需要在文件描述符数字之前加一个&
```

*永久重定向*

```shell
#!/bin/bash

exec 1>test		#在脚本运行期间使用exec重定向到某个特定的文件描述符
echo "hello world"
```

*在脚本中输出重定向*

```shell
#exec允许将STDIN重定向到Linux系统的上的文件中
exec 0> testfile
```

*可使用mktemp命令在本地目录中创建一个临时文件*

### Linux信号

| 信号 | 值      | 描述                           |
| ---- | ------- | ------------------------------ |
| 1    | SIGHUP  | 挂起进程                       |
| 2    | SIGINT  | 终止进程                       |
| 3    | SIGQUIT | 停止进程                       |
| 9    | SIGKILL | 无条件终止进程                 |
| 15   | SIGTERM | 可能的话终止进程               |
| 17   | SIGSTOP | 无条件停止进程，但不是终止进程 |
| 18   | SIGTSTP | 停止或暂停进程，但不终止进程   |
| 19   | SIGONT  | 继续运行停止的进程             |

*终止进程：Ctrl+C*<br>

*暂停进程：Ctrl+Z*(停止的进程会继续保留在内存中，并能从上次停止的位置继续运行)<br>

*后台运行脚本*

```shell
./test.sh &	#在命令后加上&
```

*使用cron时间表定期执行脚本*

```shell
15 10 * * * command		#每天10:15执行一个命令
15 16 * * 1 command		#每周一16:15执行
00 12 1 * * command		#每个月的第一天12点执行
```

### shell中的函数

```shell
#创建函数

function name {		#name和{之间有空格
    commands
}


#!/bin/bash
count=0
function fun1 {
	while [ $count -lt 5 ]
	do
		count=$[ $count+1 ]
		echo $count
	done
}
result=`fun1`		#也可将函数的输出保存到shell变量中
echo $result

#使用return
#!/bin/bash
function db {
	read -p "enter a value: " value
	return $[ $value*2 ]		#return返回函数的退出码(0~255)
}
db
echo "the new value is $?"		#$?显示退出码
```

*在函数中传递变量*

```shell
#函数可以使用标准的参数环境变量来代表命令行上传给函数的参数，也可以使用特殊变量$#来判断传给函数的参数个数
#!/bin/bash
function add {
	if [ $# -eq 0 ] || [ $# -gt 2 ]	#$#判断输入的参数个数
	then
	echo -1
	elif [ $# -eq 1 ]
	then
		echo $[ $1 + $1 ]
	else
		echo $[ $1 + $2 ]
	fi
}
value=`add 10 15`
echo $value

#使用local关键字保证了变量只能局限在函数中

```

























































