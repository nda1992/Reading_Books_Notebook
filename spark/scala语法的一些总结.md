# scala语法总结

### \_和\_*的用法

-  _表示参数

```scala
(1 to 3).map(_*2)	//IndexedSeq[Int] = Vector(2, 4, 6)
(1 to 9).filter(_%2==0)		//res0: IndexedSeq[Int] = Vector(2, 4, 6, 8)
```

- 元组

```scala
val t = (1, 3.14, "Fred")
t._1		//Int = 1
t._2		//Double = 3.14
t._3		//String = Fred
```





















