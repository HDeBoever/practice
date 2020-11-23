import json
import pandas as pd
with open('dataNov-18-2020.json', 'r') as f:
	data = json.load(f)

df = pd.DataFrame.from_dict(data['data'])

print(df)
