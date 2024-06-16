# Dynamic Programming:

# Maximum sum from non adjacent numbers:
inputs=[1,2,3,1]
dp=[]

for i in range(0,len(inputs)):
    dp.append(0)

dp[0]=inputs[0]
for i in range(1,len(inputs)):
    pick=inputs[i]
    if i>1:
        pick+=dp[i-2]
    no_pick=dp[i-1]
    dp[i]=max(pick,no_pick)
print(dp[len(inputs)-1])