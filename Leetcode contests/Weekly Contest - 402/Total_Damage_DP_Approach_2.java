import java.util.*;
public class Total_Damage_DP_Approach_2
{
    public int getOutput(HashMap<Integer,Integer> pair, ArrayList<Integer> lists,int prev,int index,int[][] dp)
    {
        if(index == lists.size())
        {
            return 0;
        }
        if(dp[prev+1][index]!=-1)
        {
            return dp[prev+1][index];
        }
        int not_take = getOutput(pair, lists, prev, index+1,dp);
        int take = 0;
        if(prev==-1 || lists.get(index) - lists.get(prev) >= 3 )
        {
            int element = lists.get(index);
            take = (pair.get(element) * element) + getOutput(pair, lists, index, index+1,dp);
        }
        return dp[prev+1][index]=Math.max(not_take, take);
    }
    public static void main(String[] args) {
        Total_Damage_DP_Approach_2  obj = new Total_Damage_DP_Approach_2();
        Scanner rs=new Scanner(System.in);
        int n = rs.nextInt();
        int power[] = new int[n];
        for(int i = 0; i < n; i++ )
        {
            power[i] = rs.nextInt();
        }
        //Sorting the array
        Arrays.sort(power);
        ArrayList<Integer> lists = new ArrayList<>();
        //Insertion of distinct arrays
        for(int num:power)
        {
            if(lists.size()>0 && lists.get(lists.size()-1) == num)
            {
                continue;
            }
            lists.add(num);
        }
        HashMap<Integer,Integer> pair = new HashMap<>();
        for(int num:power)
        {
            pair.put(num, pair.getOrDefault(num, 0)+1);
        }
        int dp[][] = new int[lists.size()+1][lists.size()+1];
        System.out.print(obj.getOutput(pair, lists, -1, 0,dp));
    }
}