# 自动装箱和注解

Java中基本数据类型的对象类型：Double、Float、Integer、Short、Character和Boolean<br>

- Character构造函数

Character(char ch)

获取Character对象中的char值：char charValue()

- Boolean构造函数

Boolean(boolean boolvalue)/Boolean(String boolvalue)

获取Boolean对象中的boolean值：boolean booleanValue()

- 数值类型

-----byte byteValue()

double doubleValue()

-----float floatValue()

Integer(int num)/Integer(String str)-----int intValue()

long longValue()

short shortValue()



### 自动拆箱

如果将基本数据类型转换为对象，就会发生自动装箱，如果对象转换为基本类型，就会发生自动拆箱<br>

### 注解

所有注解只包含方法声明，不能为这些方法提供方法体.<br>

**当使用RUNTIME保留策略时，可以使用反射获取注解**<br>

*使用发射的第一步是获取Class对象，表示希望获取其中注解的类，其中一种获取Class对象的方法是getClass()*<br>

*获取Class对象后，可以使用其方法获取类声明中各个条目相关信息*

- 以下是一个关于反射与注解应用的例子

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //@Rentention表示保留策略，RUNTIME表示将注解永久保留
@interface MyAnno{
    String str();
    int val();
        }

public class Meta {
    /**
     * 这个注解被链接到myMeth()方法
     *
     * 注解名称以@作为前缀，后面跟位于圆括号的成员初始化列表
     * */
    @MyAnno(str="Annotation Example",val=100)
    public static void myMeth(){
        Meta meta = new Meta();
        try{
            Class<?> c = meta.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno myAnno = m.getAnnotation(MyAnno.class);      //可以获取与对象相关联的特定注解
            System.out.println(myAnno.str()+" "+myAnno.val());

        }catch(NoSuchMethodException exc){
            System.out.println("Method Not Found");
        }
    }
    public static void main(String args[]){
        myMeth();
    }
}
```

**标记注解**

- 标记注解不包含成员，标记注解的唯一作用就是标记声明.

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}

public class Marker {
    @MyMarker
    public static void myMethod(){
        Marker ob = new Marker();
        try{
            Method m = ob.getClass().getMethod("myMethod");
            if (m.isAnnotationPresent(MyMarker.class)){     //确定标记是否存在
                System.out.println("MyMarker is present.");
            }
        }catch(NoSuchMethodException exc){
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String args[]){
        myMethod();
    }
}
```

















