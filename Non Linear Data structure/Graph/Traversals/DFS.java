package Graph.Traversals;
import java.util.*;

public class DFS {
    public ArrayList<Integer>get_Output(ArrayList<ArrayList<Integer>>obj,int vertices)
    {
        ArrayList<Integer>bfs=new ArrayList<>();
        Stack<Integer> stack = new Stack<Integer>(); 
        System.out.println("Enter the starting node:");
        boolean visited[]=new boolean[vertices+1];
        Scanner rs=new Scanner(System.in);
        int starting_node=rs.nextInt();
        stack.add(starting_node);
        visited[starting_node]=true;
        while(!stack.isEmpty())
        {
            Integer num=stack.pop();
            bfs.add(num);
            for(Integer get_neighbours:obj.get(num))
            {
                if(visited[get_neighbours]==false)
                {
                    visited[get_neighbours]=true;
                    stack.add(get_neighbours);
                }
            }
        }
        return bfs;
        

    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
        Scanner rs = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int vertices = rs.nextInt();
        
        for (int i = 1; i <=vertices+1; i++) {
            obj.add(new ArrayList<>());
        }

        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                if (i != j) {
                    System.out.println("If you wish to add edges from " + (i) + " to " + (j) + " Press 1");
                    int choice = rs.nextInt();
                    if (choice == 1) {
                        obj.get(i).add(j);
                        obj.get(j).add(i);
                    }
                }
            }
        }

        for (int i = 1; i <= vertices; i++) {
            System.out.println("Adjacency list of vertex " + (i) + ": " + obj.get(i));
        }
        DFS dfs1=new DFS();
        ArrayList<Integer>dfs=dfs1.get_Output(obj,vertices);
        for(Integer num1:dfs)
        {
            System.out.println(num1);
        }
        
    }
}
