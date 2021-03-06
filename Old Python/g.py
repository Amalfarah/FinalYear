#done by Amal
from flask import Flask
#import libraries
import geopandas as gpd
from shapley.geometry import Point, LineString, Polygon
import networkx as nx
import osmnx as ox
import matplotlib.pyplot as plt
from descartes import PolygonPatch
from IPython.display import IFrame
ox.config(log_console=True, use_cache=True)
# 1. Place you are interested
place = "Stockholm, Sweden"
# 2. Transportation mode
mode = "walk"
# 3. Create network graph from place and mode
G = ox.graph_from_address(place, distance=1500, simplify=True, network_type=mode)
# 4. Plot the network graph
fig, ax = ox.plot_graph(G);
plt.tight_layout()
plt.show()
#app = Flask('__name__')

#@app.route('journey')
