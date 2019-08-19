# Linux常用命令总结

## 常用的网络命令

### netstat

```shell
netstat -nap | grep port 			#将会显示使用该端口的应用程序的进程 id

netstat –tcp or netstat –t 			#将会显示 TCP 连接

#netstat命令使用举例如下：
  netstat 				#显示本机网络连接情况。
  netstat –a 		# 显示所有的有效连接信息，包括已建立的连接（ESTABLISHED）和监听的连接请求（LISTENING）
  netstat –ac  		#以连续的形式显示所有的有效连接信息，每隔1秒刷新1次显示，直到用户中断显示。
  netstat -i  			#显示系统中所有网络接口信息，包括物理网卡、网卡别名和本地回环网卡。
  netstat –n 			#显示系统中所有已建立的连接。
  netstat –r 			#显示路由表。
  netstat –ta 			#显示有效的TCP连接。
  netstat –ua 			#显示有效的UDP连接。
  netstat –s 			#显示各个协议的统计信息。
  netstat -an | grep 2811 		#显示端口号为2811的网络连接信息
```

### route

```shell
#用于查看或修改主机和网络的路由信息
```

### ping

```shell
#ping命令用来检查网络连接情况，ping命令执行时使用ICMP传输协议，给目标主机发出要求回应的信息，若目标主机的网络功能没有问题，就会返回回应信息
```

### service

```shell
# service命令能够将目录“/etc/init.d/”中有关网络服务或系统服务脚本程序以一种统一的格式执行，格式为：“service 脚本程序 选项”，常用选项有：status、stop、start、restart。service

service network status		#查看网络工作状况
service network stop			#关闭当前主机中的网卡，该操作将停止当前主机的对外网络连接
service network start			#打开当前主机中的网卡，该操作使当前主机获取IP地址，进行对外网络连接
service network restart			#先执行service network stop的功能，再执行service network start的功能
```







