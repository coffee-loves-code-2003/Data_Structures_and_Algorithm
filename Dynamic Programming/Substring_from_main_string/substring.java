import java.util.*;
public class substring {
    static ArrayList<String>o1=new ArrayList<>();
    String generate_SubStrings(String input,String ans,int count)
    {

        for(int i=0;i<input.length();i++)
        {
            ans=generate_SubStrings(input,ans+input.substring(i, count),count+1);
        }
    }
    public static void main(String[] args)
    {
        substring obj=new substring();
        Scanner rs=new Scanner(System.in);
        String input=rs.next();
        String ans="";
        int count=1;
        obj.generate_SubStrings(input,ans,count);
        System.out.println(o1);
    }
    
}
