def unboundedKnapsack(K,arr,index,target):
    if index==0:
        return arr[index]
    if index<0:
        return 0
    if target<0:
        return 0
    max_step=-99999999
    for i in range()