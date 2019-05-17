import socket

'''
实现UDP程序：客户端和服务端
'''

def receive():
    s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    s.bind(("",5000))
    data,addr=s.recvfrom(1024)
    print("receive message:{}".format(data))
    s.close()

def send():
    s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    s.sendto(b"hello",("172.16.66.253",5000))
    s.close()

