import java.util.*;
import java.util.Map.Entry;

public class gridtraveller_memoization
{
    public long compute(int m,int n,HashMap<String,Long> obj)
    {
        String key=m+","+n;
        for(Entry<String,Long> obj1:obj.entrySet())
        {
            if(obj1.getKey().equals(key))
            {
                return obj1.getValue();
            }
        }
        if(m==1 && n==1)
        {
            return 1L;
        }
        if(m==0 || n==0)
        {
            return 0L;
        }
        obj.put(m+","+n,compute(m-1,n,obj)+compute(m,n-1,obj));
        return compute(m,n,obj);

    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        gridtraveller_memoization obj=new gridtraveller_memoization();
        System.out.println("Enter the m and n values\n");
        int m=in.nextInt();
        int n=in.nextInt();
        HashMap<String,Long> h1=new HashMap<>();
        System.out.print(obj.compute(m,n,h1));
    }
}