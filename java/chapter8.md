# IO

Java程序通过流执行IO.流是一种抽象(产生信息或使用信息).

### 字节流

为处理字节的输入和输出提供了方法，例如：读取和写入二进制数据<br>

java.io包中的字节流类

| 流类                  | 含义                                               |
| --------------------- | -------------------------------------------------- |
| BufferedInputStream   | 缓冲输入流                                         |
| BufferedOutputStream  | 缓冲输出流                                         |
| ByteArrayInputStream  | 读取字节数组内容的输入流                           |
| ByteArrayOutputStream | 向字节数组写入内容的输出流                         |
| DataInputStream       | 包含读取Java标准数据类型的方法的输入流             |
| DataOutputStream      | 包含写入Java标准数据类型的方法的输出流             |
| FileInputStream       | 读取文件内容的输入流                               |
| FielOutputSream       | 向文件中写入内容的输出流                           |
| ObjectInputStream     | 用于对象的输入流                                   |
| ObjectOutputStream    | 用于对象的输出流                                   |
| OutputStream          | 描述输出流的抽象类                                 |
| PipeInputStream       | 输入管道                                           |
| PipeOutputStream      | 输出管道                                           |
| PrintStream           | b包含print()和println()的输出流                    |
| SequenceInputStream   | 由两个或多个按顺序依次读取的输入流组合而成的输入流 |

抽象类InputStream和OutputStream定义了其他流类实现的一些关键方法.派生的流类必须重写这两个方法.

### 字符流

字符流为处理字符的输入和输出提供了方法，使用的是Unicode编码，所以可以被国际化.<br>

字符流的两个顶层抽象类是：Reader和Writer<br>

| 流类               | 含义                       |
| ------------------ | -------------------------- |
| BufferedReader     | 缓冲的输入字符流           |
| BufferedWriter     | 缓冲的输出的字节流         |
| CharArrayReader    | 从字符数组读取内容的输入流 |
| CharArrayWriter    | 向字符数组写入内容的输出流 |
| FileReader         | 从文件读取内容的输入流     |
| FileWriter         | 向文件中写入内容的输出流   |
| FilterReader       | 过滤的读取器               |
| FilterWriter       | 过滤的写入器               |
| InputStreamReader  | 将字节转换成字符的输入流   |
| LineNumberReader   | 计算行数的输入流           |
| OutputStreamWriter | 将字符转换成字节的输出流   |
|                    |                            |
|                    |                            |
|                    |                            |

















































