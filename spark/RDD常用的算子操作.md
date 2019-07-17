# RDD常用算子操作

RDD将操作分为两类:transformation与action。无论执行了多少次transformation操作，RDD都不会真正执行运算，只有当action操作被执行时，运算才会触发。而在RDD的内部实现机制中，底层接口则是基于迭代器的，从而使得数据访问变得更高效，也避免了大量中间结果对内存的消耗。<br>

Transformation:延迟加载数据，Transformation会记录元数据信息，当计算任务触发Action时，才会真正开始计算；<br>

Action:立即加载数据，开始计算<br>

```scala
//通过并行化scala集合创建RDD
val rdd1 = sc.parellelize(Array(1,2,3,4,5))

//使用map做运算,map的作用是将所有的元素应用到一个函数中
val rdd2 = sc.parallelize(List(5,2,3,1,4)).map(_*2).sortBy(x=>x,true)

//filter：将List中的每个数据进行函数造作，挑选出大于10的值。 
val rdd3 = rdd2.filter(_>10)

//collect：将最终结果显示出来

//flatMap:对数据先进行map操作，再进行flat（碾压）操作
rdd4.flatMap(_.split(' ')).collect

//join连接操作
val rdd1 = sc.parallelize(List(("tom", 1), ("jerry", 2), ("kitty", 3)))
val rdd2 = sc.parallelize(List(("jerry", 9), ("tom", 8), ("shuke", 7)))
val rdd3 = rdd1.join(rdd2)
/*
output:
Array[(String, (Int, Int))] = Array((tom,(1,8)), (jerry,(2,9)))
*/

//groupByKey 
val rdd3 = rdd1 union rdd2 
rdd3.groupByKey 
rdd3.groupByKey.map(x=>(x._1,x._2.sum)).collect()
/*
output:
Array[(String, Int)] = Array((tom,9), (shuke,7), (kitty,3), (jerry,11))
*/

//reduceByKey:将key相同对应的value相加起来
val a4 = sc.parallelize(List(('c', 1), ('d', 1), ('b', 1), ('b', 2), ('b', 3), ('a', 1), ('a', 2)))
a4.reduceByKey(_+_).collect()
//output:Array[(Char, Int)] = Array((a,3), (b,6), (c,1), (d,1))



//在字符串中如何统计相邻字符对出现的次数。意思就是如果有A;B;C;D;B;C字符串，则（A,B）,(C,D),(D,B)相邻字符对出现一次，(B,C)出现两次
/*
A;B;C;D;B;D;C
B;D;A;E;D;C
A;B
*/

data.map(_.split(";")).flatMap(x=>{
      for(i<-0 until x.length-1) 
      	yield (x(i)+","+x(i+1),1)
    }).reduceByKey(_+_).foreach(println)

/*
output：
(A,E,1)
(E,D,1)
(D,A,1)
(C,D,1)
(B,C,1)
(B,D,2)
(D,C,2)
(D,B,1)
(A,B,2)
*/
```

































