import java.util.*;
public class One {
    public static void main(String[] args) {
        Scanner rs=new Scanner(System.in);
        int test_case=rs.nextInt();
        for(int i=0;i<test_case;i++)
        {
            int n=rs.nextInt();
            int max_number=2;
            int max_sum=2;
            for(int i1=2;i1<=n ;i1++)
            {
                int sum=0;
                for(int j1=1;j1<=n;j1++)
                {
                    if(i1*j1<=n)
                    {
                        sum=sum+(i1*j1);
                    }
                    else if(max_sum<sum)
                    {
                        max_sum=sum;
                        max_number=i1;
                        break;
                    }
                }
            }
            System.out.println(max_number);
        }
    }
}
