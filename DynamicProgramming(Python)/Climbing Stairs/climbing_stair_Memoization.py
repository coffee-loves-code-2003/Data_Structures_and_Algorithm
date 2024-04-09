def climbing(N,dict1):
    if N in dict1.keys():
        return dict1.get(N)
    if N==0:
        return 1
    if N<0:
        return 0
    dict1[N]=climbing(N-1,dict1)+climbing(N-2,dict1)
    return climbing(N-1,dict1)+climbing(N-2,dict1)
N=int(input("Enter the stairs size"))
dict1={}
print(climbing(N,dict1))