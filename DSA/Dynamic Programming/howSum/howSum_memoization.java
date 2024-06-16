import java.util.Map.Entry;
import java.util.*;
public class howSum_memoization
{
    public ArrayList<Integer> calculate_howSum(int target,int limit,int array[],HashMap<Integer,ArrayList<Integer>>h1)
    {
        for(Entry<Integer,ArrayList<Integer>> e:h1.entrySet())
        {
            if(target==e.getKey())
            {
                return e.getValue();
            }
        }
        if(target==0)
        {
            return new ArrayList<Integer>();
        }
        if(target<0)
        {
            return null;
        }
        for(int i=0;i<limit;i++)
        {
            int remainder=target-array[i];
            ArrayList<Integer>obj1=calculate_howSum(remainder, limit, array,h1);
            h1.put(target,obj1);
            if(obj1!=null)
            {
                obj1.add(array[i]);
                return obj1;

            }
        }
        
        return null;
    }
    public static void main(String[] args)
    {
        howSum_memoization obj=new howSum_memoization();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of the array\n");
        int limit=in.nextInt();
        int array[]=new int[limit];
        System.out.println("Enter the target sum\n");
        int target=in.nextInt();
        System.out.println("Enter the array elements\n");
        for(int i=0;i<limit;i++)
        {
            array[i]=in.nextInt();
        }
        HashMap<Integer,ArrayList<Integer>>a1=new HashMap<Integer,ArrayList<Integer>>();
        System.out.print(obj.calculate_howSum(target,limit,array,a1));
    }
}