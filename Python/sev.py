import socket
from socket import *
from flask import Flask
app = Flask('__name__')

#HOST = '' #local host
#PORT = 12345 #open port 7000 for connection
serv = socket(AF_INET,SOCK_STREAM)
serv.bind(('192.168.1.93',1000))
serv.listen(5)
while True:
    conn, addr = serv.accept()
    print("got connection from", addr)
    from_client = ''
    data = conn.recv(40)
    print (data)
    conn.send("I am SERVER".encode())
    conn.close()
    print ('client disconnected')
