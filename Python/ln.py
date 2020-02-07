import geocoder
from geopy.distance import geodesic
from datetime import datetime
import time
from datetime import timedelta
from flask import Flask
app = Flask(__name__)

@app.route("/location")
def l():
    
#uses user location and the chosen destination
#takes in the users location using IP address and the destination
    g = geocoder.ip('me')
    p = geocoder.location(input())
#finds the mile between the two locations and the hour it takes
    j = (geodesic(g.latlng,p.latlng).mi)*(geodesic(1).mi)
#finds the current time (including timezone and date)
    now = datetime.now()
    delta = timedelta(hours=j)
#adds the current time to j 
    u=now+delta

print("Miles between destinations is:",geodesic(g.latlng,p.latlng).mi,"miles")
print("Journey will roughly  take:",round(j))
print("departure Time:",now,"Arrival Time:",u)
print()
print()

