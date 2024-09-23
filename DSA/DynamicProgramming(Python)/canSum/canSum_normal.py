def canSum(target,list1,N):
    if target==0:
        return True
    if target<0:
        return False
    for i in range(0,N):
        rem=target-list1[i]
        if(canSum(rem,list1,N)==True):
            return True
    return False
target=int(input("Enter the target value"))
N=int(input("Enter the size of the list"))
list1=[]
for i in range(0,N):
    list1.append(int(input()))
print(canSum(target,list1,N))
