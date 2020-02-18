from flask import Flask
import socket
from socket import *
app = Flask('__name__')
client = socket(AF_INET,SOCK_STREAM)
client.connect(('192.168.1.93', 1000))

client.send("I am CLIENT".encode())
from_server = client.recv(40)

client.close()
print (from_server)
