//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
    
            while (t-- > 0) {
                ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                int V = sc.nextInt();
                int E = sc.nextInt();
                for (int i = 0; i < V; i++)
                    list.add(i, new ArrayList<Integer>());
                for (int i = 0; i < E; i++) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    list.get(u).add(v);
                }
                if (new Solution().isCyclic(V, list) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    // } Driver Code Ends
    
    
    /*Complete the function below*/
    
    class Solution {
        public boolean getOutput(int current_vertex,int visited[],int path_visited[],ArrayList<ArrayList<Integer>>adj)
        {
            visited[current_vertex]=1;
            path_visited[current_vertex]=1;
            for(Integer num:adj.get(current_vertex))
            {
                if(visited[num]==0)
                {
                    if(getOutput(num,visited,path_visited,adj)==true)
                    {
                        return true;
                    }
                }
                else if(path_visited[num]==1)
                {
                    return true;
                }
            }
            path_visited[current_vertex]=0;
            return false;
        }
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            int visited[]=new int[V];
            int path_visited[]=new int[V];
            Solution obj=new Solution();
            for(int i=0;i<V;i++)
            {
                if(visited[i]==0)
                {
                   if(obj.getOutput(i,visited,path_visited,adj)==true)
                   {
                       return true;
                   }
                }
            }
            return false;
        }
    }