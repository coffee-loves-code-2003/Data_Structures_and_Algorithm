def sum_of_subsets(N,lists,weight,i):
    if weight==0:
        return 1
    if i==N:
        return 0
    if weight<0:
        return 0
    return sum_of_subsets(N,lists,weight-lists[i],i+1)+sum_of_subsets(N,lists,weight,i+1);

N=int(input("Enter the limit of the array"))
lists=[]
for i in range(0,N):
    lists.append(int(input()))
weight=int(input("Enter the weight"))
print(sum_of_subsets(N,lists,weight,0))
