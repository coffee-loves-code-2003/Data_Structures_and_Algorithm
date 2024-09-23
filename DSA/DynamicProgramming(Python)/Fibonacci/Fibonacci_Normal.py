def fibonacci(num,dict):
    if num in dict.keys():
        return dict[num]
    if(num<2):
        return 1
    dict[num] =fibonacci(num-1,dict)+fibonacci(num-2,dict)
    return dict[num]
num=int(input("Enter the number"))
dict={}
for i in range(0,num):
    print(fibonacci(i,dict))