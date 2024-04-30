def func_result(arr,target,index):
    if target==0:
        return True
    if index==0:
        return (arr[index]==target)
    not_take_element=func_result(arr,target,index-1)
    take_element=False
    if target>=arr[index]:
        take_element=func_result(arr,target-arr[index],index-1)
    return take_element | not_take_element
    

N=int(input("Enter the size of the array"))
arr=[]
for i in range(0,N):
    arr.append(int(input()))
total_sum=sum(arr)
if(total_sum//2):
    print('false')
    SystemExit
print(func_result(arr,total_sum//2,N-1))