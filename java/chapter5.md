# 异常处理

### 基本知识

**异常是运行时错误.**<br>

Java的异常是用于描述一段代码发生的异常情况(错误)的对象.当出现引起异常的情况时，就会创建用来表示异常的对象，并在引起错误的方法中抛出异常对象.<br>

**方法可以自己处理异常，也可以继续传递异常**<br>

异常可以由Java运行时系统产生，也可以通过代码手动生成.<br>

如果在try代码块中发生异常，就将会抛出，代码可以捕获异常，并以某些方法对其进行处理.<br>

**系统生成的异常由Java运行时系统自动抛出，为了手动抛出异常，需要使用throw关键字**<br>

**从方法抛出的任何异常都必须通过一条throws字句进行指定**<br>

*所有异常类型都是内置Throwable的子类，Throwable位于异常类层次中的顶部*<br>

Throwable的两个子类：Exception和Error<br>

**Exception的一个重要子类是：RuntimeException，这种类型的异常是自动定义的，包括除零和无效数组索引类型**<br>

**当使用多条catch语句时，异常子类必须位于所有超类之前.**<br>

可以使用throw语句显示的抛出异常.*throw语句之后的执行流会停止，所有后续语句都不会执行*<br>

如果方法引发自身不进行处理的异常，则必须指明这种行为，以便方法调用者能够注意到异常.可以使用throws来实现.*throws字句列出了方法可能抛出的异常类型*

**如果finally代码块和某个try块相关联，那么finally代码块会在这个try代码块结束后执行**<br>

### Java的内置异常

在所有方法中的throws列表中不需要包含RuntimeException标准类型的异常.这些异常被成为未经检查的异常.除了这类异常外，如果方法可能产生这些异常中的某个异常，并且方法本身不进行处理，那么需要在方法的throws列表中包含该异常.这些异常被称为经检查的异常.<br>

- java.lang中某些未经检查的异常

| 异常                           | 含义               |
| ------------------------------ | ------------------ |
| ArrayIndexOutOfBoundsException | 数组索引越界       |
| NullPointerException           | 非法使用空引用     |
| IndexOutOfBoundsException      | 某些类型的索引越界 |
| ClassCastException             | 无效转换           |
| IllegalArgumentException       | 使用非法参数调方法 |

- java.lang中某些经检查的异常

| 异常                         | 含义                       |
| ---------------------------- | -------------------------- |
| ClassNotFoundException       | 类未找到                   |
| ReflectiveOperationException | 与反射相关的异常超类       |
| InterruptedException         | 一个线程被另一个线程中断   |
| IllegalAccessException       | 对类的访问被拒绝           |
| InstantiationException       | 视图为抽象类或接口创建对象 |



























