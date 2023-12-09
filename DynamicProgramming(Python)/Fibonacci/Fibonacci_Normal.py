def fibonacci(num):
    if(num<2):
        return 1
    return fibonacci(num-1)+fibonacci(num-2)
num=int(input("Enter the number"))
for i in range(0,num):
    print(fibonacci(i))