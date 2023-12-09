import java.util.*;
public class bestSum_Memoization
{
    
    ArrayList<Integer> get_Array(int N,int A[],ArrayList<Integer>obj,int target,HashMap<Integer,ArrayList<Integer>>a2)
    {
        for(Map.Entry<Integer,ArrayList<Integer>> ob:a2.entrySet())
        {
            if(target==ob.getKey())
            {
                return ob.getValue();
            }
        }
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
            ArrayList<Integer>o1=get_Array(N, A, obj, remainder,a2);
            if(o1!=null)
            {
                o1.add(A[i]);
                if(shortest==null || o1.size()<shortest.size())
                {

                    shortest=o1;
                    a2.put(target,shortest);

                }
            }
        }
        a2.put(target,null);
        return shortest;
    }
    public static void main(String[] args)
    {
         bestSum_Memoization o1=new bestSum_Memoization();
         Scanner rs=new Scanner(System.in);
         int N=rs.nextInt();
         int A[]=new int[N];
         for(int i=0;i<N;i++)
         {
            A[i]=rs.nextInt();
         }
         ArrayList<Integer>obj=new ArrayList<>();
         int target=rs.nextInt();
         HashMap<Integer,ArrayList<Integer>> a2=new HashMap<>();
         System.out.print(o1.get_Array(N,A,obj,target,a2));
    }
}