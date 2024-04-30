def find_max_sum_subsequence(inputs,N,list1,memoization):

    if N<=0:
        list1.clear()
        return 0
    max_sum=-1
    
    for i in range(1,N+1):
        if N-i>=0:
            list1.insert(0,inputs[N-i])
            if list1!=sorted(list1):
               print(list1)
               list1.pop(0)
            current_sum=sum(list1)
            max_sum=max(current_sum,find_max_sum_subsequence(inputs,N-i,list1,memoization))
            return max_sum 
        
inputs=[45,78,22,42,12,3,78]
list1=[]
memoization={}
print(find_max_sum_subsequence(inputs,len(inputs),list1,memoization))