# Check whether there exists the subset array that the summation of those subset results the target
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
target=int(input("Enter the target value"))
arr=[]
for i in range(0,N):
    arr.append(int(input()))
print(func_result(arr,target,N-1))