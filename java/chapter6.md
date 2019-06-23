# 多线程

### 基础知识

相较于进程而言，线程需要的开销较小.因为进程是重量级任务，需要有自身的地址空间.从一个进程到另一个进程上下文的开销很大.而线程是轻量级任务，它们共享地址空间，并且相互合作共享与同一个进程.因此，线程之间的上下文切换开销较小.

*Java中的所有类库在设计时都考虑了多线程*<br>

Java利用线程使得整个环境都能够异步执行.<br>

Java多线程的优点是消除了主循环/轮询机制，可以暂停一个线程而不贵停止程序的其他部分.<br>

线程有多种状态，线程可以处于运行状态，只要过得CPU就准备运行.运行的线程可以被挂起，这回临时停止线程的活动，挂起的线程可以被恢复，从而允许线程从停止处恢复运行.当等待资源时，线程会被阻塞，**线程一旦终止，就不能再恢复**<br>

### 线程优先级

Java中都为每个线程指定了优先级.线程的优先级是一些整数，它们指定了一个线程相对于另一个线程的优先程度.线程的上下文切换规则：

- 线程自愿放弃控制.线程显式放弃控制权、休眠、IO之前阻塞，都会出现这种情况.在这种情况下，检查所有其他线程，并且准备运行的线程中优先级最高的那个线程会获得CPU资源；
- 线程被优先级更高的线程取代.对于该情况，没有放弃控制权的线程不管正在做什么，都会被高优先级线程取代.只要高优先级线程希望运行，它就会取代优先级低的线程，这种现象称为抢占式多任务处理.

### 同步

因为多线程为程序引入了异步行为，所以提供一种需要时强制同步的方法.例如：一个线程在读数据时，必须阻止其他线程向该数据写入数据.<br>

**在java中，如果调用对象的同步方法，就会自动进入对象的隐式监视器.一旦某个线程位于一个同步方法中，其他线程就不能调用同一个对象的任何其他同步方法**<br>

### 消息传递

**Java中的消息传递系统允许某个线程进入对象的同步方法，然后进行等待，直到其他线程显式的通知这个线程退出为止**<br>

### Thread类和Runnable接口

Java的多线程是基于Thread类、Thread类方法及其伴随接口Runnable而构建的.为了实现多线程，程序可以扩展Thread类或实现Runnable接口.<br>

*Thread类定义的方法*

| 方法          | 含义                            |
| ------------- | ------------------------------- |
| getName()     | 获取线程名称                    |
| getPriority() | 获取线程优先级                  |
| isAlive()     | 确定线程是否还在运行            |
| join()        | 等待线程终止                    |
| run()         | 线程的入口点                    |
| sleep()       | 挂起线程一段时间                |
| start()       | 通过调用线程的run()方法启动线程 |

### 主线程

- 其他线程都是从主线程中产生的
- 主线程必须是最后才结束执行的线程，因为它需要执行各种关闭动作.

可以使用currentThread()方法获取对主线程的引用

```java
public class CurrentThreadDemo {
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        System.out.println("Current thread name is:"+t);

        t.setName("My thread");

        System.out.println("current thread name is:"+t);

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Main thread interrupted");
        }
    }
}
```

Note：对线程的其他分析<br>

sleep()方法使得线程从调用时挂起。暂缓执行指定的时间间隔(毫秒数).

```java
static void sleep(long milliseconds) throws InterruptedException
//会抛出InterruptedException异常
```

### 创建线程

- 实现Runnable接口
- 扩展Thread类

1. 实现Runnable接口

为了实现Runnable接口，类只需要实现run()方法:public void run()<br>

**在run方法的内部，定义促成新的线程代码，run()方法可以调用其他方法，使用其他类、也可声明变量，就像main线程一样.run方法为程序中另外一个并发线程的执行建立了入口点，当run方法返回时，这个线程就结束**

*在创建了实现Runnable接口的类后，可以在类中实例化Thread类型对象，Thread类的其中一个构造函数*

```java
Thread(Runnable threadOb,String threadName)
    //在该构造函数中，threadOb是实现了Runnable接口的类的实例，这定义了从何处开始执行线程，新线程的名称由threadName指定
```

**在创建了新线程之后，只有调用线程的start()方法，线程才会执行，该方法是在Thread类中声明的.**<br>









