import java.util.*;
public class Total_Damage_DP_Redundant_Solution
{
    public long getOutput(int[] power,HashMap<Integer, Integer> dontuse, int index, int length)
    {
        if(index == length)
        {
            return 0L;
        }
       
        long not_take = getOutput(power, dontuse, index+1, length);
        long take = 0L;
        if(!dontuse.containsKey(power[index] - 1) && !dontuse.containsKey(power[index] - 2) && !dontuse.containsKey(power[index] +1) && !dontuse.containsKey(power[index] +2))
        {
            dontuse.put(power[index], dontuse.getOrDefault(power[index], 0) +1);
            take = power[index] + getOutput(power,dontuse,index+1,length);
            dontuse.put(power[index] , dontuse.get(power[index])-1);
            if(dontuse.get(power[index])==0)
            {
                dontuse.remove(power[index]);
            }
        }
        return Math.max(not_take,take);
    }
    public static void main(String[] args) {
        Total_Damage_DP_Redundant_Solution  obj = new Total_Damage_DP_Redundant_Solution();
        Scanner rs=new Scanner(System.in);
        int n = rs.nextInt();
        int power[] = new int[n];
        for(int i = 0; i < n; i++ )
        {
            power[i] = rs.nextInt();
        }
        HashMap<Integer, Integer> dontuse = new HashMap<>();
        System.out.println(obj.getOutput(power,dontuse,0,power.length));
    }
}