list1 = [1, 2, 3, 4, 5, 6]
list2 = [7, 8, 9, 10, 11, 12]
list3 = []
for x in list1:
    if x % 2 != 0:
        list3.append(x)
print(list3)
for y in list2:
    if y % 2 == 0:
        list3.append(y)
print(list3)
