import java.util.*;
public class kill_captain_america
{
    public boolean possibledoor(HashMap<Integer,Integer> adj_list,int to,int from,int N)
    {
        int visited[] = new int[N+1];
        visited[from] = 1;
        while(visited[to] != 1)
        {
            if(!adj_list.containsKey(from))
           {
               break;
           }
           int current_neighbour = adj_list.get(from);
           if(visited[current_neighbour] == 0)
           {
            from = current_neighbour;
            visited[from] = 1;
           }
           else
           {
            break;
           }
        }
        if(visited[to] == 1)
        {
            return true;
        }
        return false;

    }
    public int getOutput(HashMap<Integer,Integer> adj_list, int N,int M)
    {
        int count = 0;
        for(int i = 1;i <= N;i++)
        {
            int temp_count = 0;
            int visited[] = new int[N+1];
            for(int j = 1;j <= N;j++)
            {
                if(i != j)
                {
                    if(possibledoor(adj_list, i, j, N))
                    {
                        ++temp_count;
                    }
                    else
                    {
                        break;
                    }

                }
            }
            if(temp_count == N-1)
            {
                ++count;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner rs = new Scanner(System.in);
        int N = rs.nextInt();
        int M = rs.nextInt();
        HashMap<Integer,Integer> adj_list = new HashMap<>();
        for(int i = 1;i <= N;i++)
        {
            System.out.println("Its neighbour vertex");
            int edge = rs.nextInt();
            adj_list.put(i,edge);
        }
        kill_captain_america obj =new kill_captain_america();
        System.out.print(obj.getOutput(adj_list,N,M));
    }
}