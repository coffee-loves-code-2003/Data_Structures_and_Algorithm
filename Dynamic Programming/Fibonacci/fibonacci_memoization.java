import java.util.*;
import java.util.Map.Entry;
public class fibonacci_memoization
{

    public Long calculate_fibo(int num,HashMap<Integer,Long> obj)
    {
        for(Entry<Integer,Long> obj1:obj.entrySet())
        {
            if(obj1.getKey()==num)
            {
                return obj1.getValue();
            }
        }
        if(num<=2)
        {
            return 1L;
        }
        obj.put(num,calculate_fibo(num-1,obj)+calculate_fibo(num-2,obj));
        return calculate_fibo(num, obj);


    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the term to check its fibinacci number");
        int num=in.nextInt();
        fibonacci_memoization obj=new fibonacci_memoization();
            HashMap<Integer,Long> obj1=new HashMap<>();

        System.out.print(obj.calculate_fibo(num,obj1));
    }
}