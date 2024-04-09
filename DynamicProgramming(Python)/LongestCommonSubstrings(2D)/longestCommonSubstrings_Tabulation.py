# Dynamic Programming (2D)

# Given the string s1="abcd" and s2="abjk" find the longest common substrings 
# Here the longest common substring is "ab" because from s1 and s2 "ab" is the only substring 
# which has maximum length

s1=input("Enter the string 1:")
s2=input("Enter the stirng 2:")
dp=list()
for i in range(0,len(s1)+1):
    dp[0][i].append(0)
for i in range(0,len(s2)+1):
    dp[i][0].append(0)
count=0
for i in range(1,len(s1)+1):
    for j in range(1,len(s2)+1):
        if(s1[i-1]==s2[j-1]):
            dp[i][j]=1+dp[i-1][j-1]
            count+=1
        else:
            dp[i][j]=0
print(count)