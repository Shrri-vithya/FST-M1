import pandas
from pandas import ExcelFile
from pandas import ExcelWriter
data = {
    "FirstName": ["Satvik", "Avinash", "Lahri"],
    "LastName": ["Shah", "Kati", "Rath"],
    "Email": ["satshah@example.com", "avinashk@example.com", "lahri.rath@example.com"],
    "PhoneNumber": ["4537829158", "5892184058", "4528727830"]
}

dataframes = pandas.DataFrame(data)
print(dataframes)
writer = ExcelWriter("UserData.xlsx")
dataframes.to_excel(writer, 'Sheet1', index=False)
writer.close()
