import java.util.*;
import java.util.Map.Entry;

public class sum_of_subset_memoization {
    public boolean subset_equals_target(HashMap<Integer,Boolean> obj,int target,int limit,int array[])
    {
        for(Entry<Integer, Boolean> ob:obj.entrySet())
        {
            if(ob.getKey()==target)
            {
                return ob.getValue();
            }
        }
        if(target==0)
        {
            return true;
        }
        if(target<0)
        {
            return false;
        }
        for(int i=0;i<limit;i++)
        {
            int remainder=target-array[i];
            if(subset_equals_target(obj, remainder, limit, array)==true)
            {
                obj.put(target,true);
                return true;
            }
        }
        obj.put(target,false);
        return false;
    }
    public static void main(String[] args)
    {
        sum_of_subset_memoization obj=new sum_of_subset_memoization();
        Scanner in=new Scanner(System.in);
        HashMap<Integer,Boolean> obj1=new HashMap<>();
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
        System.out.print(obj.subset_equals_target(obj1,target,limit,array));
    }
}
