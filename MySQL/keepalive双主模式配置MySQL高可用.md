# keepalived主主模式配置MySQL高可用

```
实验的机器：
master1:192.168.132.121
master2:192.168.132.122
虚拟IP:192.168.132.120
```

事先需要三台机器上安装好MySQL和keepalived

-  配置keepailve

```conf
! Configuration File for keepalivedd

#master1配置

global_defs {
   router_id db01
}

vrrp_instance VI_1 {
    state BACKUP
    interface ens33
    virtual_router_id 51
    priority 100						#实例中的优先级
    nopreempt
    advert_int 1
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    virtual_ipaddress {			#虚拟IP地址
        192.168.132.120
    }
}
virtual_server 192.168.132.120 3306 {
    delay_loop 6
    persistence_timeout 50
    protocol TCP

    real_server 192.168.132.121 3306 {
        notify_down /etc/keepalivedd/kill_keepalivedd.sh
        TCP_CHECK {
            connect_timeout 3
            nb_get_retry 3
            connect_port 3306
            delay_before_retry 3
        }
    }
}
```



```conf
#master2配置
! Configuration File for keepalived

bal_defs {
   router_id db02
}

vrrp_instance VI_1 {
    state BACKUP
    interface ens33
    virtual_router_id 51
    priority 90
    nopreempt
    advert_int 1
    authentication {
        auth_type PASS
        auth_pass 1111
    }
    virtual_ipaddress {
        192.168.132.120
    }
}
virtual_server 192.168.132.120 3306 {
    delay_loop 6
    persistence_timeout 50
    protocol TCP

    real_server 192.168.132.122 3306 {
        notify_down /etc/keepalived/kill_keepalived.sh
        TCP_CHECK {
            connect_timeout 3
            nb_get_retry 3
            connect_port 3306
            delay_before_retry 3
        }
    }
}
```

- 启动keepalived

```bash
systemctl start keepalived
```

- 客户端连接192.168.132.120，此时连接成功。停掉server1的服务，再次192.168.132.120发现也能成功连接.



