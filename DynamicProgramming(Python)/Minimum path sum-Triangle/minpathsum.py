# The problem statement is given the array which is in jagged form particularly in this problem it is in triangle format
# like this

# 1
# 2  3
# 3  6  7
# 8  9  6  10

# You can either go diagonally or directly downwards to the next row that is if i is the row 
# the column in the next row either be (i+1,j+1) or (i+1,j) 

# Find the minimum path sum among every path

def minimum_path_sum(triangle_array,i,j,length_of_last_row):
    if i==length_of_last_row-1:
        return triangle_array[i][j]
    direct=triangle_array[i][j]+minimum_path_sum(triangle_array,i+1,j,length_of_last_row)
    diagonal=triangle_array[i][j]+minimum_path_sum(triangle_array,i+1,j+1,length_of_last_row)
    return min(direct,diagonal)

triangle_array=[[1,0,0,0],[2,3,0,0],[3,6,7,0],[8,9,6,10]]
length_of_last_row=len(triangle_array[0])
print(minimum_path_sum(triangle_array,0,0,length_of_last_row))