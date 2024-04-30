# Dynamic Programming:

# Frog Jump:

# There is a frog on the first step of an N stairs long staircase. 
# The frog wants to reach the Nth stair. the height[i] is the height of the height[i+1].
# The energy lost in the jump h[i-1]-h[j-1]. If the frog in the ith stairs it can jump
# to i+1 stair or i+2 stair. Find the minimum total energy 
# used by the frog to reach from 1st stair to nth stair


    
height=[10,20,50,70,50,40]
dp=[]
for i in range(0,len(height)):
    dp.append(0)
for i in range(1,len(height)):
    left=dp[i-1]+abs(height[i]-height[i-1])
    right=999999999
    if i>1:
        right=dp[i-2]+abs(height[i]-height[i-2])
    dp[i]=min(left,right)
print(dp[len(height)-1])