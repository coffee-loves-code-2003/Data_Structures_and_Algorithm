def generate_Permutations(string_lists,fixed_point,end):
    if(fixed_point==end):
        print(string_lists)
        return
    for i in range(fixed_point,end+1):
        swap(i,fixed_point)
        generate_Permutations(string_lists,fixed_point+1,end)
        swap(i,fixed_point)

def swap(i,j):
    temp=string_lists[i]
    string_lists[i]=string_lists[j]
    string_lists[j]=temp
string_in=input("Enter the string")
string_lists=list(string_in)
fixed_point=0;
end=len(string_in)-1
generate_Permutations(string_lists,fixed_point,end)

