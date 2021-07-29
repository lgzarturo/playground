# -*- coding: utf-8 -*-
import json
import csv

with open('/Users/revenatium/Downloads/accounts.json') as json_file:
    data = json.load(json_file)

accounts_data = data['accounts']

data_file = open('/Users/revenatium/Downloads/accounts.csv', 'w', encoding='utf-8')

csv_writer = csv.writer(data_file)

count = 0

for account in accounts_data:
    if count == 0:
        header = account.keys()
        csv_writer.writerow(header)
        count += 1
    csv_writer.writerow(account.values())
data_file.close()
