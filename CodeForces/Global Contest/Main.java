import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner rs=new Scanner(System.in);
        int test_case=rs.nextInt();
        for(int i=0;i<test_case;i++)
        {
            int n=rs.nextInt();
            if(n==1)
            {
                System.out.println("NO");
                continue;

            }
            int arr[]=new int[n];
            for(int j=0;j<n;j++)
            {
                arr[j]=rs.nextInt();
            }
            int first_element=arr[0];
            int last_element=arr[n-1];
            if(first_element==last_element)
            {
                System.out.println("NO");
                continue;
            }
            else{
                System.out.println("YES");
                int mid=n/2;
                for(int j=0;j<n;j++)
                {
                    if(mid==j)
                    {
                        System.out.print("B");
                    }
                    else{
                        System.out.print("R");
                    }
                }
                System.out.println();

            }
        }
        
    }
}