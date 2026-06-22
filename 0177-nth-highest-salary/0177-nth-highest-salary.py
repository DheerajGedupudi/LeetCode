import pandas as pd

def nth_highest_salary(employee: pd.DataFrame, N: int) -> pd.DataFrame:
    col_name = f'getNthHighestSalary({N})'
    if N <= 0:
        return pd.DataFrame({col_name: [None]})
    salaries = employee.sort_values(by='salary', ascending=False)['salary'].unique()
    if salaries.size < N:
        return pd.DataFrame({col_name: [None]})
    return pd.DataFrame({col_name: [salaries[N-1]]})