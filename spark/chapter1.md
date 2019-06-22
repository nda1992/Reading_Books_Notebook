# pyspark的基础应用

因为我比较喜欢Python，而对Scala不是很熟悉，所以这里我主要使用pyspark来进行练习.

```python
from pyspark import SparkConf,SparkContext
conf=SparkConf().setAppName('spark1').setMaster('local')
sc=SparkContext(conf=conf)
data=[1,2,3,4,5]
dis=sc.parallelize(data,numSlices=5)	#并行计算
rdd=sc.textFile('/home/aaa/Linux_shell/test1.txt')
rdd.collect()	#执行Action()操作，读取数据，返回list
```

