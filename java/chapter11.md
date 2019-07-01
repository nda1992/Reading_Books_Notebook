# Java库

### 字符串处理

String/StringBuffer/StringBuilder类是java.lang中定义的，所有程序都可以自动使用，这些类被声明为final.<br>

```java
//字符数组
char chars[]={'a','b','c'};
String s = new String(chars)

//字节数组
byte ascii=[]={66,67,68,69,70};
String(ascii);
//从数组创建String对象都会复制数组的内容，在创建字符串后，如果修改数组的内容，String对象不会发生变化

String(StringBuffer str)
    
String(StringBuffer str)
       
//1、提取字符串
    char charAt(int where);
//2、将字符串转换为字符数组
	char[] toCharArray()
//3、比较两个字符串是否相等
    boolean equals(Object str)	//equals比较的是String对象中的字符；==比较两个对象的引用
//4、比较两个字符串是否相等（忽略大小写）
    boolean equalsIgnoreCase(String str)
//5、用于比较字符串大小(>0:调用字符串大于str;<0:调用字符串小于str;=0:两个字符串相等)
    int compareTo(String str)
//6、字符串第一次出现的索引
    int indexOf(int ch)
//7、子串第一次出现的索引
    int indexOf(String str)
//从指定位置开始查找
    int indexOf(int ch,int startIndex)
    int lastindexOf(int ch,int startIndex)
    int indexOf(String str,int startIndex)
    int lastindexOf(String str,int startIndex)
//8、修改字符串，因为String是不可变对象，因此必须复制到StringBuffer或StringBuilder，或使用String类提供的方法来构造字符串修改后的新副本        
    String subString(int startIndex)	//提取子串
    String subString(int startIndex,int endIndex)    
//9、字符串替换
    String replace(char original,char replacement)	//original被替换的字符，replacement指定替换字符
    String replace(charSequence original,charSequence replacement)	//字符序列的替换 
//10、移除开头和结尾的所有空白字符，返回字符串的副本
    String trim()
```

```java
StringBuffer：可以修改字符串，线程安全
StringBuilder：不是线程安全
如果可以修改的字符串将被多个线程修改，并且没有使用其他同步措施的话，必须使用StringBuffer，而不能使用StringBuilder
```

### java.lang

```j
Class类封装了类或接口的运行时状态，Class类型的对象是加载类时自动创建的，不能显示的声明Class对象.
通常，Object类定义的getClass()方法来获取Class对象.
```



### java.util(集合框架)

![集合框架](../images/集合框架.png)

### java.util



### java.io



### NIO





### 网络编程



































