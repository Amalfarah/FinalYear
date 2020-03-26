from flask import Flask
from flask import jsonify
from flask import json
import xlrd 
from collections import OrderedDict
import simplejson as json

app = Flask('__name__')

@app.route('/database')
def database():
    data = xlrd.open_workbook('C:\Users\Amal_\Documents\Amal\Final Year\database\Database.xls')
    sh1 = data.sheet_by_index(0)
    s = []
    

    for rx in range(1,sh1.nrows):
        datab = OrderedDict()
        row_values = sh.row_values(rownum)
        datab['country_id'] = row_values[0]
        datab['partner'] = row_values[1]
        datab['non-partner'] = row_values[2]

        s.append(datab)
        
    j = json.dumps(s)
    with open('data.json','w') as f:
       f.write(j)
   

