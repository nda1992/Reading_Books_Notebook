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


使用exit命令

```

































































