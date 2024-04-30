def get_output(costs,N):
    take=costs[N]+get_output(costs,N-1)
    not_take=get_output(costs,N-1)
    return min(take,not_take)
costs=[]
N=int(input("Enter the size of the cost array"))
for i in range(0,N):
    costs.append(int(input()))
print(get_output(costs,N-1))