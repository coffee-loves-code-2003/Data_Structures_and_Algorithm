import java.util.*;
public class MaxFunds {
    public int check(int fund[],ArrayList<ArrayList<Integer>>obj,int visited_grid[],int number)
    {
        int max=0;
    
        for(int i=1;i<=number;i++)
        {
            int sum=0;
            if(visited_grid[i]==0)
            {
                visited_grid[i]=1;
                sum+=fund[i];
            for(Integer num1:obj.get(i))
            {
                if(visited_grid[num1]==0)
                {
                    sum+=fund[num1];
                    System.out.println(sum+" + "+fund[num1]);
                    visited_grid[num1]=1;

                }
                
            }
            }
            
            max=Math.max(sum,max);
        }
        return max;
    }
    public static void main(String[] args)
    {
        Scanner rs=new Scanner(System.in);
        int number=rs.nextInt();
        int fund[]=new int[number+1];
        for(int i=1;i<=number;i++)
        {
            fund[i]=rs.nextInt();
        }
        ArrayList<ArrayList<Integer>> obj = new ArrayList<>();
        for(int i=1;i<=number+1;i++)
        {
            obj.add(new ArrayList<Integer>());
        }
        for(int i=1;i<=number;i++)
        {
            System.out.print("For the vertex"+i+"\n");
           for(int j=1;j<=number;j++)
           {
            System.out.print("Do you want edge from "+i+" to"+j+"1:Yes"+"0:No");
            int choice=rs.nextInt();
            if(choice==1)
            {
                if(i!=j)
            {

                obj.get(i).add(j);
                obj.get(j).add(i);
            }
            }
            
           }
        }
        int visited_grid[]=new int[number+1];
        for(int i=1;i<=number;i++)
        {
            System.out.print("For index "+i+" "+obj.get(i));
        }
        MaxFunds max=new MaxFunds();
        System.out.print(max.check(fund,obj,visited_grid,number));
    }
}
