import json
import csv

with open('json/data.json') as f:
  data = json.load(f)

data_rows = []
for account in data['items']:
  permissions = ', '.join(account['permissions']['effective'])
  data_rows.append([
    account['id'], account['accountId'], account['name'],
    account['websiteUrl'], permissions
  ])

with open('output/data.csv', 'w', newline='') as file:
  writer = csv.writer(file, delimiter='|', quoting=csv.QUOTE_ALL)
  writer.writerow(['id', 'accountId', 'name', 'website', 'permissions'])
  writer.writerows(data_rows)

