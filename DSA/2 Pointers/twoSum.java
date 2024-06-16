import java.util.*;
public class twoSum
{
    static void generateTwoSum(int A[],int target,int N)
    {
        int start=0;
        int end=N-1;
        int two_indices[]=new int[2];
        int index=0;
        while(start<end)
        {
            if(A[start]+A[end]==target)
            {
                two_indices[index]=start;
                two_indices[++index]=end;
                break;
            }
            if(A[start]>target)
            {
                ++start;
            }
            if(A[end]>target)
            {
                --end;
            }
        }
        if(start>=end)
        {
            System.out.println("No indices found");
            return;
        }
        for(int i=0;i<2;i++)
        {
            System.out.println(two_indices[i]);
        }
    }
    public static void main(String[] args)
    {
        Scanner rs=new Scanner(System.in);
        int N=rs.nextInt();
        int A[]=new int[N];
        for(int i=0;i<N;i++)
        {
            A[i]=rs.nextInt();
        }
        int target=rs.nextInt();
        generateTwoSum(A,target,N);
    }
}