import java.util.*;
public class the_rat
{
   private static int global_visited_hops = Integer.MAX_VALUE;
    public void getOutput(int N,int arr[][],int visited[][],int current_i,int current_j,int visited_hops,int[][] result)
    {
        if(current_i == N - 1 && current_j == N - 1)
        {
            if(global_visited_hops > visited_hops)
            {   
                for(int i = 0;i < N;i++)
                {
                    for(int j = 0;j < N;j++)
                    {
                        result[i][j] = visited[i][j];
                    }
                }
                global_visited_hops = visited_hops;

            }
            return;
        }     
        for(int i = 1;i <= arr[current_i][current_j];i++)
        {
            int delta_i = current_i + i;
            int delta_j = current_j;
            if(delta_i < N && arr[delta_i][delta_j] != 0)
            {
                visited[delta_i][delta_j] = 1;
                getOutput(N,arr,visited,delta_i,delta_j,visited_hops+1,result);
                visited[delta_i][delta_j] = 0;
            }
        }
        //Considering Rightward(Priority)
        for(int i = 1;i <= arr[current_i][current_j];i++)
        {
            int delta_i = current_i;
            int delta_j = current_j + i;
            if(delta_j < N && arr[delta_i][delta_j] != 0)
            {
                visited[delta_i][delta_j] = 1;
                getOutput(N,arr,visited,delta_i,delta_j,visited_hops+1,result);
                visited[delta_i][delta_j] = 0;
            }
        }
        return;

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
        int visited[][] = new int[N][N];
        the_rat obj = new the_rat();
        visited[0][0]=1;
        int result[][] = new int[N][N];
        result[0][0] = 1;
        obj.getOutput(N,arr,visited,0,0,0,result);
        if(global_visited_hops == Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            for(int i = 0;i < N;i++)
            {
                for(int j = 0;j < N;j++)
                {
                    System.out.print(result[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}