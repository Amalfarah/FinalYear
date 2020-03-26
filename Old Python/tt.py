from flask import Flask
# importing googlemaps module
import googlemaps 
  
# Requires API key 
gmaps = googlemaps.Client(key='AIzaSyCVXE9KvCUPbnHo0zaOc7z3QpAHA3Gej7g') 

def e():
# Requires cities name 
    my_dist = gmaps.distance_matrix('Delhi','Mumbai')['rows'][0]['elements'][0] 
  
# Printing the result 
    print(my_dist) 
