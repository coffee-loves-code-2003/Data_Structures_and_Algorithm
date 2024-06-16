import java.util.*;

public class Main {
    int its_adjacent_vertex;
    int its_associated_weight;
    public Solution()
    {
         
    }
    public Solution(int its_adjacent_vertex, int its_associated_weight) {
        this.its_adjacent_vertex = its_adjacent_vertex;
        this.its_associated_weight = its_associated_weight;
    }

    public void dfs(ArrayList<ArrayList<Solution>> adj_list_with_weight, int current_vertex, int visited[], Stack<Integer> stack) {
        visited[current_vertex] = 1;
        // System.out.println(current_vertex);
        for(int i=0;i<adj_list_with_weight.get(current_vertex).size();i++)
        {
            int adjacent_vertex=adj_list_with_weight.get(current_vertex).get(i).its_adjacent_vertex;
            if(visited[adjacent_vertex]==0)
            {
                dfs(adj_list_with_weight,adjacent_vertex,visited,stack);
            }
        }
        stack.push(current_vertex);
       
    }

    public int[] findShortest(Stack<Integer> stack, ArrayList<ArrayList<Solution>> adj_list_with_weight, int minimum_distance[]) {
        while (!stack.isEmpty()) {
            int current_vertex = stack.pop();
            for (int i=0;i<adj_list_with_weight.get(current_vertex).size();i++) {
                int adjacent_vertex = adj_list_with_weight.get(current_vertex).get(i).its_adjacent_vertex;
                int weight = adj_list_with_weight.get(current_vertex).get(i).its_associated_weight;
                
                if (minimum_distance[current_vertex] + weight < minimum_distance[adjacent_vertex]) {
                    minimum_distance[adjacent_vertex] = minimum_distance[current_vertex] + weight;
                }
            }
        }
        for(int i=0;i<minimum_distance.length;i++)
        {
            if(minimum_distance[i]==9999999)
            {

            
            minimum_distance[i]=-1;
            }
        }
        return minimum_distance;
    }

    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Solution>> adj_list_with_weight = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Solution> adj=new ArrayList<Solution>();
            adj_list_with_weight.add(adj);
        }
        for (int i = 0; i < m; i++) {
            int current_vertex = edges[i][0];
            int its_adjacent_vertex = edges[i][1];
            int its_associated_weight = edges[i][2];
            adj_list_with_weight.get(current_vertex).add(new Solution(its_adjacent_vertex, its_associated_weight));
        }
        int visited[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Solution obj = new Solution();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                obj.dfs(adj_list_with_weight, i, visited, stack);
            }
        }
        int minimum_distance[] = new int[n];
        for(int i=0;i<n;i++)
        {
            minimum_distance[i]=9999999;
        }
        minimum_distance[0] = 0; // Start vertex
        return obj.findShortest(stack, adj_list_with_weight, minimum_distance);
    }
}
