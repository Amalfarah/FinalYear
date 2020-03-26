from flask import Flask
import socket
from socket import *
app = Flask('__name__')
client = socket(AF_INET,SOCK_STREAM)
client.connect(('10.100.168.150', 1000))#change based on location

client.send("From Client: I am CLIENT".encode())
from_server = client.recv(40)

client.close()
print (from_server)
