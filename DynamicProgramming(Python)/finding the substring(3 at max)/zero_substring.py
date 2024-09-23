N=int(input("Enter the size of the array"))
list1=[]
for i in range(0,N):
    list1.append(int(input()))
list3=[]
for i in range(0,N):
    list2=[]
    if(i+2<N):
        for j in range(i,i+3):
            list2.append(list1[j])
            print(list2)
    if sum(list2)==0 and len(list2)!=0:
        
        list3.append(list2)

print(list3)
    