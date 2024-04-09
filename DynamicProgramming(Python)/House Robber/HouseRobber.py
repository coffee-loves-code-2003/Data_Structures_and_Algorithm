def houseRobber(array,index,dict):
    if index in dict.keys():
        return dict[index]
    if index==0:
        return array[index]
    if index<0:
        return 0
    take=array[index]+houseRobber(array,index-2,dict)
    not_take=houseRobber(array,index-1,dict)
    dict[index]=max(take,not_take)
    return dict[index]

array=[1,2,3]
dict1={}
dict2={}
print(max(houseRobber(array[0:len(array)-1],len(array)-2,dict1),houseRobber(array[1:],len(array)-2,dict2)))