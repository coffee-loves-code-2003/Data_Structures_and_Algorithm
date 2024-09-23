import java.util.*;


public class distinct_islands {
    int x,y;
    public distinct_islands()
    {

    }
    public distinct_islands(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public void getOutput(ArrayList<String>a1,int visited[][],int grid[][],int base_row,int base_col,Stack<distinct_islands>stack,int current_row,int current_col)
    {
        stack.add(new distinct_islands(current_row,current_col));

        
        visited[current_row][current_col]=1;
        
        while(!stack.isEmpty())
        {
            

            distinct_islands di=stack.pop();
            int difference_coordinates_x=di.x-base_row;
            int difference_coordinates_y=di.y-base_col;
            a1.add(difference_coordinates_x+","+difference_coordinates_y);
            int delta_row[]={-1,0,1,0};
            int delta_col[]={0,1,0,-1};
            for(int i=0;i<4;i++)
            {
                int neighbour_row=di.x+delta_row[i];
                int neighbour_col=di.y+delta_col[i];
                if(neighbour_row>=0 && neighbour_row<grid.length && neighbour_col>=0 && neighbour_col<grid[0].length && visited[neighbour_row][neighbour_col]==0&&grid[neighbour_row][neighbour_col]==1)
                {
                    visited[neighbour_row][neighbour_col]=1;
                    stack.add(new distinct_islands(neighbour_row, neighbour_col));
                }
            }
        }
        
    }
        public static void main(String[] args) {
            distinct_islands obj=new distinct_islands();
            Scanner rs=new Scanner(System.in);
            System.out.println("Enter the row and column");
            int row=rs.nextInt();
            int col=rs.nextInt();
            int grid[][]=new int[row][col];
            int visited[][]=new int[row][col];
            Set<ArrayList<String>>o1=new HashSet<>();
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    grid[i][j]=rs.nextInt();
                }
            }
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<col;j++)
                {
                    if(visited[i][j]==0 && grid[i][j]==1)
                    {
                        ArrayList<String>a1=new ArrayList<>();
                        Stack<distinct_islands>stack=new Stack<>();
                        obj.getOutput(a1,visited,grid,i,j,stack,i,j);
                        o1.add(a1);
                        
                    }
                }
            }
            System.out.println(o1.size());
            rs.close();
        }
}
