# aansible学习之路
```记录了ansible的学习过程，重点是如何将该工具应用到实际工作中```

### ansible基础

ansible是一个自动化运维工具。它可以高效完成批量任务，以及经常需要重复操作的任务。下面列举了ansible的使用场景：

- 同时在100台服务器上安装nginx，并在安装后全部启动
- 将某个文件一次性拷贝到100台服务器上
- 当需要为不断新增加进来的服务器部署redis时服务时

ansible有一个很重要的特点是：幂等性（根据目标的不同状态来确定是否需要进行操作），它可以保证重复执行同一个操作时，所得到的结果都是一样的.

ansible只需要依赖ssh就可以很方便的对其他主机进行管理.比如可以使用如下命令pingtest70的机器：

```bash
ansible test70 -m ping
#上述命令需要满足：
#1）ansible所在的主机可以通过ssh连接到受管理的机器

#2）受管理的机器的IP等信息已经添加到ansible的管理清单中
```

### ansible常用的模块

> 每个模块都自带有很多操作时需要用到的参数，需要参考ansible的文档

#### 操作文件

- fetch(从远程主机中拉取文件到ansible主机)

```
ansible test70 -m fetch -a "src=/etc/test.txt dest=/etc/ansible"
```

- copy（将ansible主机上的文件拷贝到远程主机中）

```
ansible test70 -m copy -a "src=/etc/copytest dest=/tmp/"
```

- file(对文件的基本操作：创建文件或目录、修改文件、删除文件和更改文件的权限等)

```
# 在test70上创建名为testfile的文件
ansible test70 -m file -a "path=/testdir/testfile state=touch"

# 在test70上创建名为testdir的目录
ansible test70 -m file -a "path=/testdir/testdir state=directory"
```

- blockinfile(在指定的文件中插入一段文本，这段文本是被标记过的，在以后的操作中可以通过标记找到这些文本，可对它进行修改或者删除)

```
#在test.txt中插入两行
ansible test70 -m blockinfile -a 'path=/testdir/test.txt block="systemctl start mariadb\nsystemctl start httpd"'
```

- lineinfile(确认某一行文本是否存在于指定的文件中，或者确保从文件中删除文本，也可以通过正则表达式替换某一行文本)

```

```

- find模块（在远程主机中查找到符合条件的文件）

```
#查找/testdir目录中的文件内容是否有包含abc字符串的文件
ansible test70 -m find -a 'paths=/testdir contains=".*abc.*"'
```

- replace

```
#可以根据指定的正则表达式替换文件中的字符串。所有匹配到的字符串都会被替换
```

#### 操作命令

- command

```
#使用本地的主机可以在远程主机上执行命令
ansible test70 -m command -a "ll"
```

- shell

```
与command不同，shell模块在远程主机中执行命令时，会经过远程主机上的/bin/bash程序来进程处理
```

- script

```
可以在远程主机上执行ansible主机的本地脚本，不需要拷贝到远程主机中
```

#### 系统类

- cron

```
管理远程主机中的计划任务

在主机test70上创建计划任务，任务名称为test crontab，任务于每天2点30分执行，任务内容为输出test字符
absible test70 -m cron -a "-name='test crontab' minute=30 hour=1 job;'echo test'"
```

- service

```
使得主机具备管理远程主机服务的能力，如开启或关闭远程主机中的Apache服务

ansible test70 -m service -a "name=apache state=started"
```

- user

```
可以对远程主机进行用户管理的操作
如创建用户、修改用户、删除用户等
```

- group

```

```

#### 包管理

- yum_repository

```
管理远程主机上的yum仓库
```

- yum

```
通过yum源管理软件包
```

#### 实验操作

```
在远程的主机上安装nginx
可以使用上述的过程得到下面的操作命令

ansible test70 -m yum_repository -a 'name=aliEpel description="alibaba EPEL" baseurl=https://mirrors.aliyun.com/epel/$releasever\Server/$basearch/'

ansible test70 -m yum -a 'name=nginx disable_gpg_check=yes enablerepo=aliEpel'

ansible test70 -m service -a "name=nginx state=started"


但是还有一种更好的方式是使用ansible 的playbook
playbook依赖yaml格式的文件
test.yml格式的文件如下：
```

```yaml
--- 
    - hosts: test70
    remote_user: root
    task:
    	- name: Ping the host
    	ping:
    	- name: make directory test
    	file:
    		path: /testdir/test
    		state: directory

```

```
使用ansible-playbook指定test.yaml
ansible-playbook test.yml
```

未完待续...



























