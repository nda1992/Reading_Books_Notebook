# lambda表达式

### 基础概念

lambda表达式本质上是一个匿名方法，但是这个方法不是独立执行的，而是用于**实现由函数式接口**定义的的另一个方法.<br>

**函数式接口是只包含一个抽象方法的接口**，这个方法指明了接口的目标用途.<br>

函数式接口会默认实现Object的公有方法.<br>

###  lambda语法

操作符"->"：左侧指定了lambda表达式的所有参数，右侧指定了lambda体(lambda表达式要执行的动作).<br>

lambda表达式不是独立执行的，而是构成一个**函数式接口定义的抽象方法的实现.**<br>

```java
interface MyNumber{
    double getvalue();
}

public class lambda {
    public static void main(String args[]){
        MyNumber myNumber;
        /*
        * 当目标类型上下文使用lambda表达式时，会自动创建实现了函数式接口的实例，函数式接口声明的抽象方法的行为由lambda表达式定义，当通过目标调用该方法时，就会执行lambda表达式
        * */
        myNumber=()->100.1;
        System.out.println(myNumber.getvalue());
    }
}
```

**lambda表达式可以用来执行任何与其兼容的lambda表达式**<br>

### 块lambda表达式

块lambda表达式扩展了lambda表达式内部可以处理的操作类型，因为它允许lambda体包含更多条语句.<br>

```java
interface NumericFunc{
    int func(int n);
}

public class lambda {
    public static void main(String args[]){
          NumericFunc factorial=(n)->{
          int result=1;
            for (int i = 1; i <=n ; i++) {
                result*=i;
            }
            return result;
        };
        System.out.println(factorial.func(3));
    }
}
```

### 泛型函数式接口

lambda不能是泛型，但是与lambda表达式相关联的函数式接口可以泛型.<br>

定义泛型函数式接口可以只需要注意数据类型<br>

```java
interface SomFunc<T>{
    T func(T t);
}

public class lambda {
    public static void main(String args[]){
        SomFunc<String> reverse=(str)->{
            String result="";
            int i;
            for (int j = str.length()-1; j >=0 ; j--) {
                result+=str.charAt(j);
            }
            return result;
        };
        System.out.println(reverse.func("hello"));

        SomFunc<Integer> factorial=(n)->{
            int result=1;
            for (int i = 1; i <=n ; i++) {
                result*=i;
            }
            return result;
        };
        System.out.println(factorial.func(3));
    }
}
```

### 作为参数传递lambda表达式

为了将lambda表达式作为传递参数，接受lambda表达式的参数的类型必须是**与该lambda表达式兼容的函数式接口的类型**<br>

```java
interface StringFunc{
    String func(String n);
}
public class lambda {
    public static void main(String args[]){
        String inStr = "中国 广东 深圳";
        String outStr;
        outStr=stringOp((str)->str.toUpperCase(),inStr);
        System.out.println(outStr);

        outStr=stringOp((str)->{
            String result="";
            int i;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)!=' ') result+=str.charAt(j);
            }
            return result;
        },inStr);
        System.out.println(outStr);
    }
    static String stringOp(StringFunc sf,String n){
        return sf.func(n);
    }
}
```

### lambda表达式与异常

lambda表达式可以抛出异常，凡事异常必须与函数式接口的抽象方法的throws字句列出的异常兼容.

### 方法引用

方法引用提供了一种引用而不执行方法的方式.这种特性与lambda表达式相关，因为它也需要由兼容的函数式接口构成的目标类型上下文.

```java
interface StringFunc1{
    String func(String n);
}

class MyStringRev {
    static String strReverse(String str){
        String result="";
        int i;
        for (int j = str.length()-1; j >=0; j--) {
            result+=str.charAt(j);
        }
        return result;
    }
}

public class MyStringOps {
    public static void main(String args[]) {
        String inStr = "lambda for java";
        String outStr;
        outStr=stringOps(MyStringRev::strReverse,inStr);	//MyStringRev::strReverse的计算结果为对象引用
        System.out.println(inStr);
        System.out.println(outStr);
    }
    static String stringOps(StringFunc sf,String s){	//strReverse与StringFunc函数式接口兼容
        return sf.func(s);
    }
}
```









































































