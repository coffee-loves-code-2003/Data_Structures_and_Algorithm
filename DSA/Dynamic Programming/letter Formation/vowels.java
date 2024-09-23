// # Input: n = 2
// # Output: 15
// # Explanation: The 15 sorted strings that consist of vowels only are
// # ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
// # Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.


import java.util.*;
public class vowels
{
    static int count=0;
    public void getOutput(int start,int N,String s[],ArrayList<String>obj)
    {
        if(obj.size()==N)
        {
            System.out.println(obj);
            ++count;
            obj.remove(obj.size()-1);
            return;
        }
        for(int i=start;i<5;i++)
        {
            
            obj.add(s[i]);
            getOutput(i,N,s,obj);
            if(i==4 && obj.size()>0)
            {
                obj.remove(obj.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        String s[]={"a","e","i","o","u"};
        Scanner rs=new Scanner(System.in);
        int N=rs.nextInt();
        vowels o1=new vowels();
        ArrayList<String>obj=new ArrayList<>();
        o1.getOutput(0,N,s,obj);
        System.out.println(count);
    }
}
