def fib(x):
    a = 0
    b = 1
    print(a , b)
    for y in range(x):
        c = a + b
        a = b
        b = c
        print(c)


value = int(input("enter the value: "))
fib(value)
