import pandas
from pandas import ExcelFile
from pandas import ExcelWriter

table = pandas.read_excel("UserData.xlsx")
print(table)
print("no of rows and cols")
print(table.shape)
print("data in email cols")
print(table["Email"])
print("first name in ascending")
print(table.sort_values("FirstName"))
