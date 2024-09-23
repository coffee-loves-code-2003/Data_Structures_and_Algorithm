# Dynamic Programming:

# Frog Jump:

# There is a frog on the first step of an N stairs long staircase. 
# The frog wants to reach the Nth stair. the height[i] is the height of the height[i+1].
# The energy lost in the jump h[i-1]-h[j-1]. If the frog in the ith stairs it can jump
# to i+1 stair or i+2 stair. Find the minimum total energy 
# used by the frog to reach from 1st stair to nth stair
def frog_jump(height,dp,N):
    if N==0:
        return 0
    if dp[N]!=-1:
        return dp[N]
    one_take = frog_jump(height,dp,N-1)+abs(height[N]-height[N-1])
    two_take=999999999
    if N>1:
        two_take=frog_jump(height,dp,N-2)+abs(height[N]-height[N-2])
    dp[N]=min(one_take,two_take)
    return dp[N]
    
height=[10,20,50,70,50,40]
dp=[]
for i in range(0,len(height)):
    dp.append(-1)
print(frog_jump(height,dp,len(height)-1))






 