import socket
from socket import *


HOST = "192.168.1.93" #local host
PORT = 1000 #open port 7000 for connection
s = socket()
s.setsockopt(SOL_SOCKET, SO_REUSEADDR, 1)
s.bind((HOST, PORT))
s.listen(5) 
while True:
    conn, addr = s.accept()
    print("got connection from", addr)
    conn.send("thank you".encode())
    conn.close()
    
