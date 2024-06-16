import java.util.*;
public class minimumweight
{
    public int dfs(ArrayList<ArrayList<Integer>>adj_list,int start,int end,int total_weight)
    public static void main(String[] args) {
        Scanner rs=new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int nodes=rs.nextInt();
        List<Integer>treeFrom =new ArrayList<>();
        List<Integer>treeTo=new ArrayList<>();
        ArrayList<ArrayList<Integer>>adj_list=new ArrayList<>();
        System.out.println("Enter the number of from nodes");
        int from_nodes=rs.nextInt();
        for(int i=0;i<from_nodes;i++)
        {
            treeFrom.add(rs.nextInt());
        }
        System.out.println("Enter the to nodes");
        for(int i=0;i<from_nodes;i++)
        {
            treeTo.add(rs.nextInt());
        }
        System.out.println("Enter the start node");
        int start=rs.nextInt();
        System.out.println("Enter the end node");
        int end=rs.nextInt();

        //Considering that the 0th node is empty and there are no adjacent nodes
        for(int i=0;i<=nodes;i++)
        {
            adj_list.add(new ArrayList<Integer>());
        }
        for(int i=0;i<treeTo.size();i++)
        {
            adj_list.get(treeFrom.get(i)).add(treeTo.get(i));
            
            adj_list.get(treeTo.get(i)).add(treeFrom.get(i));
        }
        for(int i=1;i<=nodes;i++)
        {
            System.out.println(i+" "+adj_list.get(i));
        }
        minimumweight object=new minimumweight();
        System.out.print(object.dfs(adj_list, start, end, 0));


        
    }
}