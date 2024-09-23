import java.util.*;
public class the_rat_in_the_maze_gfg {
    int current_i;
    int current_j;
    int no_of_hops;
    public the_rat_in_the_maze_gfg()
    {

    }
    public the_rat_in_the_maze_gfg(int current_i,int current_j,int no_of_hops)
    {
        this.current_i = current_i;
        this.current_j = current_j;
        this.no_of_hops = no_of_hops;
    }

    public int getOutput(int arr[][],int N)
    {
        int result = Integer.MAX_VALUE;
        Comparator<the_rat_in_the_maze_gfg> compareble=  new Comparator<the_rat_in_the_maze_gfg>() {
        

            @Override
            public int compare(the_rat_in_the_maze_gfg o1, the_rat_in_the_maze_gfg o2) {
                if(o1.no_of_hops > o2.no_of_hops)
                {
                    return 1;
                }
                else if(o1.no_of_hops < o2.no_of_hops)
                {
                    return - 1;
                }
                return 0;
            }};
        PriorityQueue<the_rat_in_the_maze_gfg> queue= new PriorityQueue<>(compareble);
        queue.add(new the_rat_in_the_maze_gfg(0,0,0));
        while(!queue.isEmpty())
        {
            the_rat_in_the_maze_gfg soln = queue.poll();
            int current_i = soln.current_i;
            int current_j = soln.current_j;
            int no_of_hops = soln.no_of_hops;
            int max_jump = arr[current_i][current_j];
            
            if(current_i == N - 1 && current_j == N - 1)
            {
                return no_of_hops;
            }
            //Considering rightward
            for(int i = 1; i <=max_jump;i++)
            {
                int delta_i = current_i;
                int delta_j = current_j+i;
                if(delta_j < N && arr[delta_i][delta_j]!= 0)
                {
                    queue.add(new the_rat_in_the_maze_gfg(delta_i,delta_j,no_of_hops+1));
                } 
            }
            //Considering downward
            for(int i = 1;i <= max_jump;i++)
            {
                int delta_i = current_i+i;
                int delta_j = current_j;
                if(delta_i < N && arr[delta_i][delta_j]!=0)
                {

                    queue.add(new the_rat_in_the_maze_gfg(delta_i,delta_j,no_of_hops+1));
                }
            }
            // System.out.println(queue);
            // System.out.println("\n\n");
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);
        int N = rs.nextInt();
        int arr[][] = new int[N][N];
        for(int i = 0;i < N;i++)
        {
            for(int j = 0;j < N;j++)
            {
                arr[i][j] = rs.nextInt();
            }
        }
        the_rat_in_the_maze_gfg obj = new the_rat_in_the_maze_gfg();
        System.out.println(obj.getOutput(arr,N));
    }
}
