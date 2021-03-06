# java多线程

### Thread类的start和run方法的区别？

start():作用是启动一个新线程，新线程会执行相应的run方法，start不会被重复调用；<br>

run():run方法与普通成员方法一样，可以被多次调用.如果单独调用run()，会在当前线程中执行，而不会启动新线程.<br>

### synchronized的原理、用法以及存在的问题

synchronized的目的就是为了保持被其包裹的代码块中的变量和数据在同一时间只能被一个线程所访问(表示该线程拿到了锁).从而实现线程之间对数据的互斥操作.<br>

*用法*：

```java
synchronized(需要一个任意的对象(锁)){
    代码块中方法操作共享数据的代码
}

/*
说明：
如果一个代码块被synchronized修饰，当一个线程获取了对应的锁，并执行该代码块时，其他线程只能一直等待，等待获取锁的线程释放锁，而这里获取锁的线程释放锁只会有两种情况：
1.获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
2.线程执行发横异常，此时JVM会让线程自动释放锁
*/
```

由于占有锁的线程可能会进行IO等耗时的操作，而其他线程在拿不到锁时则一直进行等待，这样会影响效率.因此可以使用java.util.concurrent.locks.Lock.

### Lock的使用方法

Lock可以事项同步访问机制.<br>

Lock与synchronized最大的不同是：采用synchronized不需要用户手动去释放锁，当synchronized方法或synchronized代码块执行完后，系统会自动释放对锁的占用；而Lock则必须要用户手动释放锁，如果没有主动释放锁，就有可能出现死锁的现象.<br>































