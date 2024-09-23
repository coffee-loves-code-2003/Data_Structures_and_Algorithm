import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Total_Damge_DP_Replica_Delete_and_Earn {
    public int getOutput(int[] nums,int starting_index,HashMap<Integer,Integer>map)
    {
        if(map.containsKey(starting_index))
        {
            return map.get(starting_index);
        }
        if(starting_index>=nums.length)
        {
            return 0;
        }
        int current_sum=nums[starting_index];
        int next_index=starting_index+1;
       while(next_index<nums.length && nums[starting_index]==nums[next_index] )
       {
        current_sum+=nums[starting_index];
        ++next_index;
       }
       int not_take_index=next_index;
       while( next_index<nums.length && nums[starting_index]+2>=nums[next_index] )
       {
        ++next_index;
       }
        int take_sum = current_sum + getOutput(nums, next_index, map);
        int not_take_sum = getOutput(nums, not_take_index, map);
        int result = Math.max(take_sum, not_take_sum);
        map.put(starting_index, result);
        return result;

    }
    public static void main(String[] args) {
        Total_Damge_DP_Replica_Delete_and_Earn obj = new Total_Damge_DP_Replica_Delete_and_Earn();
        Scanner rs=new Scanner(System.in);
        int n = rs.nextInt();
        int power[] = new int[n];
        for(int i = 0; i < n; i++ )
        {
            power[i] = rs.nextInt();
        }
        Arrays.sort(power);
        HashMap<Integer,Integer>map=new HashMap<>();

        System.out.println(obj.getOutput(power, 0, map));
        rs.close();

    }
}
