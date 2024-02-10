# The given problem is you are given the matrix which has M rows and N columns, where you need to find the maximum
# path sum of every starting point to every point where the cells can be selected in the consecutive rows will
# be straight or diagonally.

# 1 2 3
# 4 5 6
# 7 8 9

# In the given matrix if the selected element is 2 in the row 0 and the next cell selected can be either 4 or 5 or 6
# which is straight(5), left(4) and right(6)

def maxpathsum(values,i,j):
    if j<0 or j>=len(values[0]):
        return -1e9
    if i==0:
        return values[i][j]
    straight=values[i][j]+maxpathsum(values,i-1,j)
    left=values[i][j]+maxpathsum(values,i-1,j-1)
    right=values[i][j]+maxpathsum(values,i-1,j+1)
    return max(straight,max(left,right))


values=[[5,9,6],[11,5,2]]
N=len(values)
M=len(values[0])
maximum=-1e9
for j in  range(0,M):
    maximum=max(maximum,maxpathsum(values,N-1,j))
print(maximum)