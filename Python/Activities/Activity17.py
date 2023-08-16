import pandas as pd
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl1","AllMight"]
}

dataframes = pd.DataFrame(data)

print(dataframes)
dataframes.to_csv("user.csv", index=False)