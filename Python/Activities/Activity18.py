import pandas as pd

table = pd.read_csv("user.csv")
print(table)
print(table["Usernames"])
print(table["Usernames"][1] +" and password is "+ table["Passwords"][1])
print(table.sort_values("Usernames"))
print(table.sort_values("Passwords", ascending=False))
