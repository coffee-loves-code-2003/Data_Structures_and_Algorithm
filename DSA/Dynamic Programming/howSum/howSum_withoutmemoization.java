import java.util.*;
public class howSum_withoutmemoization
{
    public ArrayList<Integer> calculate_howSum(int target,int limit,int array[],ArrayList<Integer>a1,HashMap<Integer,ArrayList<Integer>>a2)
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
            return new ArrayList<Integer>();
        }
        if(target<0)
        {
            return null;
        }
        for(int i=0;i<limit;i++)
        {
            int remainder=target-array[i];
            ArrayList<Integer>obj1=calculate_howSum(remainder, limit, array,a1,a2);
            if(obj1!=null)
            {
                obj1.add(array[i]);
                a2.put(target, obj1);
                return a2.get(target);

            }
        }
        a2.put(target,null);
        return null;
    }
    public static void main(String[] args)
    {
        howSum_withoutmemoization obj=new howSum_withoutmemoization();
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
        ArrayList<Integer>a1=new ArrayList<Integer>();
        HashMap<Integer,ArrayList<Integer>> a2=new HashMap<>();
        System.out.print(obj.calculate_howSum(target,limit,array,a1,a2));
    }
}