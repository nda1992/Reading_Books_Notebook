# Linux相关

## cut、sed、awk、grep的使用

### cut

```shell
#例子：
echo $PATH
/root/anaconda3/bin:/usr/local/cuda-8.0/bin:/usr/local/sbt/bin:/usr/spark-2.4.0-bin-hadoop2.7/bin:/usr/jdk1.8/bin:/usr/local/sbin:

#要提取echo输出的第5列
echo $PATH | cut -d ':' -f 5
/usr/jdk1.8/bin

#要提取echo输出的第3~5列
echo $PATH | cut -d ':' -f 3,5

#要提取echo输出的第3列到最后的内容
echo $PATH | cut -d ':' -f 3-


```

