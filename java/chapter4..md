# 接口

可以使用interface指定类必须执行的操作，**接口没有实例变量**，并且方法没有方法体.**一个类可以实现任意数量的接口**<br>

如果实现了接口，那么类必须实现接口中的所有方法.<br>

接口中可以声明变量，被隐式标识为final和static，意味着实现接口的类不能修改这些变量，同时还需要初始化这些变量.所有方法和变量都隐式声明为public.

**实现接口的类可以增加自身的方法**<br>

**可以变量声明为使用接口而不是类的对象引用.对于实现接口的任何类的任何实例，都可以通过这种变量进行引用，当通过这些引用调用方法时，会根据接口当前实际引用的实例调用正确版本的方法**<br>

````java
interface Callback{
    void callback(int par);
}

class Client implements Callback{
    public void callback(int p){
        System.out.println(p);
    }
    public void NoInterface(){
        System.out.println("the method included in class Client");
    }
}

class TestInterface{
    public void static main(String[] args){
        Callback c = new Client();
        c.callback(5);	//output:	5
    }
}
````

Note:c被声明为接口类型Callback，而被赋值为Client类的一个实例，因此c可以调用callback方法，但是不能访问Client类的其他成员(即不能方法NoInterface()方法)

```java
interface Callback{
    void callback(int m);
}

class Another implements Callback{
    @Override
    public void callback(int m) {
        System.out.println(m*m);
    }
}

class Client implements Callback{
    @Override
    public void callback(int m) {
        System.out.println(m);
    }
}
public class TestIface {
    public static void main(String args[]){
        Callback c = new Client();
        Another a = new Another();
        c.callback(5);  //调用了Client的callback方法,output:5
        c=a;
        c.callback(5);  //调用了Another的callback方法,output:25
    }
}
```

**如果类包含了一个接口，但是没有实现该接口定义的全部方法，那么必须将类声明为abstract类**

```java
abstract class Incomp implements Callback{}
```

类Incomp没有实现callback方法，但是派生自Incomp的所有类必须实现callback方法，或者本省也被声明为abstract















