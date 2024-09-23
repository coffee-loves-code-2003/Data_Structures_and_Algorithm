import java.util.*;
import java.lang.*;
import java.io.*;

public class Avgperm
{
    public void getOutput(int number,ArrayList<Integer>list,boolean[] ds,double minimum,ArrayList<Integer>min)
    {
        if(list.size()==number)
        {
         double sum=0.0;
            for(int i=0;i<number-2;i++)
            {
                sum=sum+((list.get(i)+list.get(i+1)+list.get(i+2)))/3;
            }
            
            if (minimum > sum) {
                minimum = sum; 
                min.clear(); 
                min.addAll(list); 
            }
            return;
        }
        for(int i=0;i<number;i++)
        {
            if (ds[i] == false) {
            ds[i] = true;
            list.add(i + 1);
            getOutput(number, list, ds, minimum, min);
            list.remove(list.size() - 1);
            ds[i] = false;
    
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Avgperm obj=new Avgperm();
        Scanner rs=new Scanner(System.in);
        int test_case=rs.nextInt();
        for(int i=0;i<test_case;i++)
        {
            int number=rs.nextInt();
            ArrayList<Integer>list=new ArrayList<>();
            ArrayList<Integer> min=new ArrayList<>();
            boolean ds[]=new boolean[number];
            
            obj.getOutput(number,list,ds,Double.MAX_VALUE,min);
                    for (int element : min) {
                System.out.print(element + " ");
            }
    System.out.println();
        }
	}
}
