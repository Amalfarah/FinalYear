import googlemaps
from datetime import datetime

gmaps = googlemaps.Client(key='AIzaSyCVXE9KvCUPbnHo0zaOc7z3QpAHA3Gej7g')


now = datetime.now()
directions_result = gmaps.directions("18.997739, 72.841280",
                                     "18.880253, 72.945137",
                                     mode="driving",
                                     avoid="ferries",
                                     departure_time=now
                                    )

print(directions_result[0]['legs'][0]['distance']['text'])
print(directions_result[0]['legs'][0]['duration']['text'])
