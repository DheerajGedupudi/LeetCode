import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    df = pd.DataFrame()
    df['SecondHighestSalary'] = employee.sort_values(by='salary', ascending=False)['salary'].unique()
    df = df[1:2]
    if df.size==0:
        return pd.DataFrame({'SecondHighestSalary': [None]})
    return df