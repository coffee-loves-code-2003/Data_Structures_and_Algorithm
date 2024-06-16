import java.util.*;
public class Zero
{
    public static void main(String[] args) {
        Scanner rs=new Scanner(System.in);
        int n=rs.nextInt();
        for(int i=0;i<n;i++)
        {
            String a=rs.next();
            String b=rs.next();
            StringBuilder a1=new StringBuilder(a);
            StringBuilder b1=new StringBuilder(b);
            char c=a1.charAt(0);
            char d=b1.charAt(0);
            a1.setCharAt(0, d);
            b1.setCharAt(0, c);
            System.out.println(a1.toString()+" "+b1.toString());

        }
    }
}