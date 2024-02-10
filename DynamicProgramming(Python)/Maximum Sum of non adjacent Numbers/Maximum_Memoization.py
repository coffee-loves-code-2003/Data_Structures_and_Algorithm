def maximum(inputs,N,dict1):
    if N==0:
        return inputs[N]
    if N<0:
        return 0
    if N in dict1.keys():
        return dict1.get(N)
    pick=inputs[N]+maximum(inputs,N-2,dict1)
    no_pick=maximum(inputs,N-1,dict1)
    dict1[N]=max(pick,no_pick)
    return dict1[N]
inputs=[2,1,5,9]
N=len(inputs)-1
dict1={}
print(maximum(inputs,N,dict1))