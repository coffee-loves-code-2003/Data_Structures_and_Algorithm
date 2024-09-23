import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Superman {

    //Memoization
    // public int getOutput(int[][] buildings,int current_building,int current_height,int offset,int total_building,int[][] dp)
    // {
    //     if(current_height <= 0)
    //     {
    //         return 0;
    //     }
    //     if(dp[current_height][current_building] != -1)
    //     {
    //         return dp[current_height][current_building];
    //     }
    //     int max_result = Integer.MIN_VALUE;
    //     for(int i = 1;i <= total_building;i++)
    //     {
    //         if(current_building == i)
    //         {
    //             max_result = buildings[current_height][i] + getOutput(buildings, current_building, current_height - 1, offset, total_building,dp); 
    //         }
    //         for(int j = 1;j <= total_building;j++)
    //         {
    //             if(j != current_building)
    //             {
                    
                
    //         max_result = Math.max(max_result,buildings[current_height][i] + getOutput(buildings, j, current_height - offset, offset, total_building,dp));  
    //             }
    //         } 
    //     }
    //     return dp[current_height][current_building] = max_result;
    // }
    public static void main(String[] args) {
       Scanner rs = new Scanner(System.in);
       int N = rs.nextInt();
       int H = rs.nextInt();
       int I = rs.nextInt();
       int [][] buildings = new int[H+1][N+1];
       for(int i = 1;i <= N;i++)
       {
           int n_of_members = rs.nextInt();
           for(int member = 0;member < n_of_members;member++)
           {
               int floor = rs.nextInt();
               buildings[floor][i]++;
           }
       }
       int[][] dp = new int[H+1][N+1];
       
    //    Solution obj = new Solution();
       int result = Integer.MIN_VALUE;
    //    for(int i = 1;i <= N;i++)
    //    {
    //         //System.out.println(result);
    //         result = Math.max(result,obj.getOutput(buildings,i,H,I,N,dp));
    //    }
    //    System.out.print(result);
    for(int i = 1 ;i <= H;i++)
    {
        for(int j = 1;j <= N;j++)
        {
            dp[i][j] = buildings[i][j];
            if(i > 1)
            {
                dp[i][j] += dp[i-1][j];
            }
            if(i > I)
            {
                for(int k = 1;k <= N;k++)
                {
                    if(j != k)
                    {
                        dp[i][j] = Math.max(dp[i][j],
                                        buildings[i][j] + dp[i - I][k]);
                    }
                }
            }
            
        }
    }
    // int result  = Integer.MIN_VALUE;
    for(int i = 1;i <= N;i++)
    {
        result = Math.max(result,dp[H][i]);
    }
       System.out.print(result);
       
       
    }
}
