import socket
from socket import *
from flask import Flask
import geocoder
from geopy.distance import geodesic
from datetime import datetime
import time
from datetime import timedelta
import struct
app = Flask('__name__')
serv = socket(AF_INET,SOCK_STREAM)
serv.bind(('134.83.53.199',1000))
serv.listen(5)
while True:
    conn, addr = serv.accept()
    print("got connection from", addr)
    from_client = ''
    data = conn.recv(1000)
    print (data)
    data1=conn.recv(1000)
    print (data1)
    u= data.decode()
    print(u)
    y= data1.decode()
    print(y)
    #data from the form
    data2=conn.recv(1000)
    a = data2.decode()
    print (a)
    data3=conn.recv(1000)
    b= data3.decode()
    print (b)
    data4=conn.recv(4000)
    c= data4.decode()
    print (c)
    data5=conn.recv(2000)
    d = data5.decode()
    print (d)
    data6=conn.recv(3000)
    e = data6.decode()
    print (e)
    #p = geocoder.location(input(u))
    #print(p)
    #g=geocoder.location(input(y))
    #print(g)
    j = (geodesic(u,y).mi)*(geodesic(1).mi)
    print (round(j))
    print("Miles between destinations is:",round(j),"miles")
    now = datetime.now()
    print(now)
    delta = timedelta(hours=j)
    u=now+delta
    print("departure Time:",now,"Arrival Time:",u)
    conn.send(u.encode())
                 #"departure Time:".encode,now,"Arrival Time:".encode,u)
    #conn.send("I am SERVER".encode())
    conn.close()
    print ('client disconnected')
