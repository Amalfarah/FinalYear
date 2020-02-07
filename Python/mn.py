#Importing the geodesic module from the library 
from geopy.distance import geodesic
from datetime import datetime
import time
from datetime import timedelta
  
leytonstone = (51.568435, 0.008508)
uxbridge = (51.546668, -0.478032)
mode = "car"
now = datetime.now()

j = (geodesic(leytonstone, uxbridge).mi)*(geodesic(1).mi)
#n = j*60
#j=j*60
#m = str.split(":")
#n = (j+now.hour)*60
#arrival = j
#hours,minutes = divmod(n,60)
delta = timedelta(hours=j)
u=now+delta
#m = hours,minutes + now.hour
print("Location:",leytonstone,"Destination:",uxbridge)
print("Miles between destinations is:",geodesic(leytonstone, uxbridge).mi,"miles")
print("Journey will roughly  take:",round(j))
#print("arrival:" ,arrival)
print("departure Time:",now,"Arrival Time:",u)
print()
print()

leytonstone = (51.568435, 0.008508)
stratford = (51.540917, -0.002660)
now = datetime.now()
j = (geodesic(leytonstone, stratford).mi)*(geodesic(1).mi)
delta = timedelta(hours=j)
u=now+delta
#n = j*60
#hours, minutes = divmod(n, 60)
#print (geodesic(leytonstone, stratford).km) 
print("Miles between destinations is:",geodesic(leytonstone, stratford).mi,"miles") 
print("Journey will roughly take:",round(j))
print("departure Time:",now,"Arrival Time:",u)
print()
print()
oxford = (51.515248, -0.141861)
stratford = (51.540917, -0.002660)
now = datetime.now()
j = (geodesic(oxford,stratford).mi)*(geodesic(1).mi)
delta = timedelta(hours=j)
u=now+delta
#print (geodesic(leytonstone, stratford).km) 
print("Miles between destinations is:",geodesic(oxford, stratford).mi,"miles") 
print("Journey will roughly take:",round(j))
print("departure Time:",now,"Arrival Time:",u)








