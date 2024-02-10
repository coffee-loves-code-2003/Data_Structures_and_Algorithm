def minpathsum(values,N,M):
    if N==0 and M==0:
        return values[N][M]
    if N<0 or M<0:
        return 1e9;
    up=values[N][M]+minpathsum(values,N-1,M)
    left=values[N][M]+minpathsum(values,N,M-1)
    return min(up,left)


values=[[5,9,6],[11,5,2]]
N=len(values)
M=len(values[0])
print(minpathsum(values,N-1,M-1))