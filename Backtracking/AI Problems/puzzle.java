import java.util.*;
public class puzzle
{
    public int[] deltaRow =  {-1,1,0,0};
    public int[] deltaCol =  {0,0,1,-1};
    //Computing the permutations for the array for prechecking the puzzle if it is exhausted with every possibilities
    public void getPermutation(int visited[], Set<List<Integer>> perm,int[] array,int length,List<Integer> answer)
    {
        if(answer.size() == length)
        {
            perm.add(new ArrayList<>(answer));
            return;
        }
        for(int i = 0;i < length;i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                answer.add(array[i]);
                getPermutation(visited,perm,array,length,answer);
                visited[i] = 0;
                answer.remove(answer.size()-1);
            }
        }
        return;
    }
    public boolean isSorted(int[][] grid,int length,int rows)
    {
        if(grid[rows-1][rows-1]!= 0)
        {
            return false;
        }
        int row = 0;
        int col = 0;
        int previous_number = -1;
        for(int i = 0;i < length-1;i++)
        {
            row = i / rows;
            col = i % rows;
            if(previous_number < grid[row][col])
            {
                previous_number = grid[row][col];
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public List<Integer> getList(int[][] grid,int length)
    {
        List<Integer> lists = new ArrayList<>();
        length = grid[0].length;
        for(int i = 0;i < length;i++)
        {
            for(int j = 0;j < length;j++)
            {
                lists.add(grid[i][j]);
            }
        }
        return lists;
    }
    public boolean isSolvable(Set<List<Integer>> perm_list, int[][] grid,int length, int previous_selected_number,
                              Set<List<Integer>> my_possible_lists,int zero_i,int zero_j,int rows)
    {
        List<Integer> gotten_lists = getList(grid,length);

        if(isSorted(grid,length,rows))
        {
            return true;
        }
        for(int i = 0; i < 4;i++)
        {
            int changing_row_i = zero_i + deltaRow[i];
            int changing_col_j = zero_j + deltaCol[i];
            if(changing_row_i >= 0 && 
               changing_row_i < rows && 
               changing_col_j >= 0 && 
               changing_col_j < rows && 
               previous_selected_number != grid[changing_row_i][changing_col_j])
            {
                int temp = grid[changing_row_i][changing_col_j];
                grid[changing_row_i][changing_col_j] = 0;
                grid[zero_i][zero_j] = temp;
                // if(my_possible_lists.contains(gotten_lists))
                // {
                //     return false;
                // }
                my_possible_lists.add(new ArrayList<>(gotten_lists));
                if(isSolvable(perm_list,grid,length,temp,my_possible_lists,changing_row_i,changing_col_j,rows))
                {
                    return true;
                }
                grid[changing_row_i][changing_col_j] = temp;
                grid[zero_i][zero_j] = 0;
                
            }
        }
        return false;

    }
    public static void main(String[] args)
    {
        Scanner rs = new Scanner(System.in);
        System.out.println("Rows:");
        int rows = rs.nextInt();
        int grid[][] =  new int[rows][rows];
        int array[] = new int[rows*rows];
        int index = 0;
        int zero_i = 0;
        int zero_j = 0;
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < rows;j++)
            {
                grid[i][j] = rs.nextInt();
                array[index++] = grid[i][j];
                if(grid[i][j] == 0)
                {
                    zero_i = i;
                    zero_j = j; 
                }
            }
        }
        Set<List<Integer>> perm = new HashSet<>();
        int visited[] = new int[rows*rows];
        puzzle obj = new puzzle();
        obj.getPermutation(visited, perm, array,rows*rows, new ArrayList<>());
        Set<List<Integer>> results = new HashSet<>();
        System.out.print(obj.isSolvable(perm,grid,rows*rows,-1,results,zero_i,zero_j,rows));
        System.out.println(results);
        rs.close();
        
    }
} 