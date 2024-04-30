import java.util.*;

public class BFS {
    int node;
    int parent_node;
    public BFS()
    {

    }
    public BFS(int node,int parent_node)
    {
        this.node=node;
        this.parent_node=parent_node;
    }
    public boolean get_Output(ArrayList<ArrayList<Integer>>obj,int vertices)
    {
        ArrayList<Integer>bfs=new ArrayList<>();
        Queue<BFS> queue = new LinkedList<>();
        System.out.println("Enter the starting node:");
        boolean visited[]=new boolean[vertices+1];
        Scanner rs=new Scanner(System.in);
        int starting_node=rs.nextInt();
        queue.add(new BFS(starting_node,-1));
        visited[starting_node]=true;
        while(!queue.isEmpty())
        {
            BFS obj1=queue.poll();
            int parent=obj1.parent_node;
            for(Integer num:obj.get(obj1.node))
            {
                if(visited[num]==false)
                {
                    queue.add(new BFS(num, obj1.node));
                    visited[num]=true;

                }
                else if(num!=parent)
                {
                    return true;
                }
            }
        }
        return false;
        

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
        BFS bfs1=new BFS();
       System.out.println("Is there exists cycle"+bfs1.get_Output(obj, vertices));
        
    }
}
