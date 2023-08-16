def sum(x):
    if x>0:
        return x + sum(x-1)
    else:
        return 0
res = sum(10)
print(res)

