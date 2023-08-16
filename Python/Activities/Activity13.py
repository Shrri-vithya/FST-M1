def sum(a):
    res = 0
    print("len of list : ", len(a))
    for x in a:
        res += x
    return res


list1 = [1, 2, 3, 4, 5]

res = sum(list1)
print("sum of list values: ", res)