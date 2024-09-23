def frog_jump(N,K,height,dict1):
    if N==0:
        return 0
    min_step=99999999999
    if N in dict1.keys():
        return dict1.get(N)
    
    for i in range(1,K+1):
        if(N-i>=0):
            steps=frog_jump(N-i,K,height,dict1)+abs(height[N]-height[N-i])
            min_step=min(steps,min_step)
            dict1[N]=min_step
    return dict1[N]
height=[10,20,50,70,50,40]
K=2
dict1={}
N=len(height)-1
print(frog_jump(N,K,height,dict1))