def func_result(num):
    temp_var=num[0]
    count=0
    for i in range(0,len(num)):
         if count<=2:
            if temp_var==num[i]:
                count+=1
            else:
                temp_var=num[i]
                count=1
         else:
             temp_index=i
             for j in range(i,len(num)):
                 if temp_var!=num[j]:
                     
                     
    return num
        

N=int(input("Enter the size of the array"))
lists=[]
for i in range(0,N):
    lists.append(int(input()))
print(lists)
print(func_result(lists))
