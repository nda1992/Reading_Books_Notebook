### java基础
java的基础原则是应当只通过类的方法来访问类的实例变量，而不是使用实例对象直接操纵实例变量.

### java的对象声明
1. 当创建一个类时，就是在创建一种数据类型.new操作符动态地为对象分配内存，并返回指向对象的引用.该引用是由new为该对象分配的内存地址.
然后将这个引用存储到存储变量中。所以在java中，所有类对象都必须动态分配.举例为：
```
Animal animal;          //(1)
animal = new Animal();  //(2)
```
执行(1)表示将animal声明为Animal类型对象的引用.此时animal不指向任何对象<br>
执行(2)分配实际的对象，并将该对象的引用赋给animal，之后就可以使用animal变量了.animal实际只保存了实际Animal对象的内存地址.<br>
**Note:java中的基本数据类型不会被当作对象对待.**

new操作符在运行时为对象分配内存.即可创建在程序运行期间所需要的任意数量.

```
Animal animal = new Animal();
Animal animal_1 = animal;
```
animal和animal_1会引用同一个对象，将animal赋值给animal_1不会分配内存,因此对animal_1的修改，将会影响animal所引用的对象.
```
Animal animal = new Animal();
Animal animal_1 = animal;
animal=null;
```
animal被赋值为null，但是animal_1仍然指向原来的对象
*当将一个对象引用变量赋值给另外一个对象引用变量时，不是创建对象副本，而是创建引用副本*


### 构造函数
一旦定义构造函数，就会在创建对象之后、new操作符完成之前，立即自动调用构造函数.
对于数值类型、引用类型和boolean类型，默认值分别是0、null和false
- this关键字
this总是引用调用方法的对象

### 方法重载
方法名称相同而参数类型或参数个数不同

### 参数引用传递
向类传递参数的方式有：(1):值调用（将实参的值复制到类方法中的形参中）；(2)引用调用（将对实参的引用（而不是参数的值）
传递给形参）<br>
```
class Animal{
    int a,b;
    Animal(){}
    Animal(int x,int y){
        this.a=x;
        this.b=y;
    }
    void meth(Animal animal){
        animal.a*=2;
        animal.b/=2;
    }
    void meth(int x,int y){
        x*=2;
        y/=2;
    }
}

public class test1 {
    public static void main(String args[]){
        //传递基本数据类型时，只是传递它的副本，因此不会改变原来的值
        int a=20,b=10;
        Animal animal1 = new Animal();
        System.out.println(a+" "+b);    //a=20,b=20
        animal1.meth(a,b);
        System.out.println(a+" "+b);    //a=20,b=20

        System.out.println("-------------------------------------");

        //传递引用时，会影响用作形参的对象
        Animal animal = new Animal(20,10);
        System.out.println(animal.a+" "+animal.b);  //a=20,b=20
        animal.meth(animal);
        System.out.println(animal.a+" "+animal.b);  //a=40,b=5
    }
}
```
*当将对象引用传递给方法时，引用本身是使用值调用传递的，但是由于传递的值引用一个对象，因此值的副本仍然引用相应实参指向的同一个对象*





