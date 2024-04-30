def climbing(N):
    if N==0:
        return 1
    if N<0:
        return 0
    return climbing(N-1)+climbing(N-2)
N=int(input("Enter the stairs size"))
print(climbing(N))