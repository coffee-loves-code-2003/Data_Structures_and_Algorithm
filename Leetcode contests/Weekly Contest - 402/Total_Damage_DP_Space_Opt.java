import java.util.*;
public class Total_Damage_DP_Space_Opt {
    public static void main(String[] args) {
        Total_Damage_DP_Space_Opt obj = new Total_Damage_DP_Space_Opt();
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
        // int dp[][] = new int[lists.size()+1][lists.size()+1];
        // for(int prev = lists.size()-1; prev>=-1; prev--)
        // {
        //     for(int index = lists.size()-1; index>=0; index--)
        //     {
        //        int not_take = dp[prev+1][index+1];
        //        int take = 0;
        //        if(prev==-1 || lists.get(index) - lists.get(prev) >= 3 )
        //        {
        //             int element = lists.get(index);
        //             take = (pair.get(element) * element) + dp[index+1][index+1];
        //        }
        //         dp[prev+1][index]=Math.max(not_take, take); 
        //     }
        // }
        // System.out.print(dp[0][0]);
        int lists_length = lists.size();
        int dp[] = new int[lists_length];
        for(int i = 0; i<lists_length; i++)
        {
            int element = lists.get(i);
            dp[i] = pair.get(element) * element; 
        }
        int max = Integer.MIN_VALUE;
        System.out.println(lists);
        System.out.println(pair);
        for(int index = 0 ; index < lists_length; index++)
        {
            for(int prev = 0; prev < index; prev++)
            {
                if(lists.get(index)-lists.get(prev)>=3)
                {
                    dp[index] = dp[index]
                }
            }
            max = Math.max(dp[index],max);

        }
        System.out.println(max);
    }
}
