def print_output(start,N):
    if start>N:
        return

    print_output(start+1,N)
    print(start)

print_output(1,5)