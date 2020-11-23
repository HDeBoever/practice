# ETL pipeline using pandas

import pandas as pd

# Create an empty df

df = pd.DataFrame()

# Create column
df['name'] = ['Amanda','Henri','Sophie', 'Jay']
df['employed'] = ['Yes', 'No', 'Yes', 'Yes']
df['age'] = [ 25, 26, 30, 24]


# Pipeline time

# Group data by col, return the mean age per group
def mean_age_by_group(dataframe, col):
	return dataframe.groupby(col).mean()

# Capitalize all column headers
def uppercase_col_name(dataframe):
	dataframe.columns = dataframe.columns.str.upper()
	return dataframe

print(df.head())
print('\n')

# Crete a pipeline that apples both of the functions we declared above
print(
df.pipe(mean_age_by_group, col = 'employed')
	.pipe(uppercase_col_name)
)
