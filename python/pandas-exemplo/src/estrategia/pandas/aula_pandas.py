import pandas as pd
import numpy as np

if __name__ == '__main__':
    url = 'https://raw.githubusercontent.com/pandas-dev/pandas/main/doc/data/titanic.csv'
    data_titanic = pd.read_csv(url)
    print(data_titanic.head())
    print(data_titanic.iloc[0:3, 0:2])

