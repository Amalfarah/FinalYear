
# importing required libraries 
import requests, json 
  
# Get method of requests module 
# return response object

app = Flask('__name__')

@app.route('/journey')
# enter your api key here 
    api_key ='AIzaSyA4-CJDubMExd4b9-cwHv6jAbD1R38dW3U'

# Take source as input 
    source = input() 
  
# Take destination as input 
    dest = input() 
  
# url variable store url  
    url ='https://maps.googleapis.com/maps/api/distancematrix/json?'

    r = requests.get(url + 'origins = ' + source +
                   '&destinations = ' + dest +
                   '&key = ' + api_key) 
                     
# json method of response object 
# return json format result 
    x = r.json() 
  
# bydefault driving mode considered 
  
# print the vale of x 
    print(x)

