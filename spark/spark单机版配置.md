# spark单机版配置

Centos7上进行的配置<br>

下载好JDK，Scala和Spark<br>

如果需要HDFS支持，还需要安装Hadoop<br>

解压和安装的步骤这里不会给出<br>

由于conf/目录中没有slaves，spark-env.sh，所以需要复制这两个文件slaves.template，spark-defaults.conf.template分别对应salves和spark-env.sh

- 配置slaves，在文件中加入：

```shell
localhost
```

- 配置spark-env.sh，在文件中加入

```shell
export JAVA_HOME=/usr/local/jdk
export SCALA_HOME=/usr/local/scala
export SPARK_MASTER_IP=SparkMaster
export SPARK_WORKER_MEMORY=2g
export SPARK_WORKER_CORES=2
export SPARK_WORKER_INSTANCES=1
```

- 启动master结点：

```bash
./sbin/start-master.sh
```

- 启动spark-shell

```bash
 ./bin/spark-shell
```





















