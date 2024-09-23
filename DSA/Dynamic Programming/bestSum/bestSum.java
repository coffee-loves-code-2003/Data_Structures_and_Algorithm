import java.util.*;
public class bestSum
{
    
    ArrayList<Integer> get_Array(int N,int A[],ArrayList<Integer>obj,int target)
    {
        if(target==0)
        {
            return new ArrayList<>();
        }
        if(target<0)
        {
            return null;
        }
        ArrayList<Integer> shortest=null;
        for(int i=0;i<N;i++)
        {
            int remainder=target-A[i];
            ArrayList<Integer>o1=get_Array(N, A, obj, remainder);
            if(o1!=null)
            {
                o1.add(A[i]);
                if(shortest==null || o1.size()<shortest.size())
                {
                    shortest=o1;
                }
            }
        }
        return shortest;
    }
    public static void main(String[] args)
    {
         bestSum o1=new bestSum();
         Scanner rs=new Scanner(System.in);
         int N=rs.nextInt();
         int A[]=new int[N];
         for(int i=0;i<N;i++)
         {
            A[i]=rs.nextInt();
         }
         ArrayList<Integer>obj=new ArrayList<>();
         int target=rs.nextInt();
         System.out.print(o1.get_Array(N,A,obj,target));
    }
}