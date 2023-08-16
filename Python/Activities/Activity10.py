tuple1 = tuple(input("enter the tuples:").split(","))
for x in tuple1:
    if int(x) % 5 == 0:
        print(x)
