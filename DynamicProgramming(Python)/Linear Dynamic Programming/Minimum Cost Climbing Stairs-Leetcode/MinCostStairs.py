def func_result(N,arr):
    if N<0:
        return 0
    
    one_step=arr[N]+func_result(N-1,arr)
    two_step=arr[N]+func_result(N-2,arr)
    return min(one_step,two_step)

N=int(input("Enter the size of the array"))
arr=[]
for i in range(0,N):
    arr.append(int(input()))
print(min(func_result(N-1,arr),func_result(N-2,arr)))
