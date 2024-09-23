import math
arr=[]
def func_result(N):
    if N<=1:
        return 1
    left=math.floor(N/2)
    right=math.ceil(N/2)
    arr.append(left*right)
    
    return func_result(left)*func_result(right)
N=int(input("Enter the number"))
func_result(N)
print(sum(arr))
print(arr)