def func_result(arr,starting_index,dict):
    if starting_index==len(arr)-1:
        return True
    if starting_index>len(arr)-1:
        return False
    for i in range(1,arr[starting_index]+1):
        dict[arr[starting_index]]=func_result(arr,starting_index+i,dict)
        return func_result(arr,starting_index+i,dict)
    return False




arr=[2,0,0]
dict={}
func_result(arr,0,dict)
print(dict)
for i in dict.keys():
    if dict.get(i)==True:
        print(True)
        SystemExit
print(False)
    