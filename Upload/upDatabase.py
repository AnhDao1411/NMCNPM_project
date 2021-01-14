import pandas as pd
import csv
import firebase_admin
from firebase_admin import db, storage, credentials, firestore

cred = credentials.Certificate('./com-example-ghienphim-firebase-adminsdk-ijdjn-0b25f8f0c6.json')
firebase_admin.initialize_app(cred)

db = firestore.client()

# local
df = pd.read_csv('data_TV.csv', sep=',', encoding='UTF-8')
data = []
headers = list(df.columns.values)

line_count = 0
for i in range(len(df)):
    row = df.iloc[i, :]
    obj = {}
    for idx, item in enumerate(row):
        obj[headers[idx]] = item
    data.append(obj)
    line_count += 1

for i, d in enumerate(data):
    # key = name
    doc_ref = db.collection(u'Films').document(u'{:05d}'.format(i))
    # write
    doc_ref.set(data[i])