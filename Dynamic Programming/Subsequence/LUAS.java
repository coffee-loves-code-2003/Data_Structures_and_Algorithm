import java.util.*;
public class LUAS
{
    public void getOutput(String[] words,int[] groups,int prev_index,int current_index,List<String> ans,List<String> temp)
    {
        if(current_index==words.length)
        {
            if(ans.size() < temp.size())
            {
                ans.clear();
                ans.addAll(temp);
            }
            return ;
        }
        getOutput(words,groups,prev_index,current_index+1,ans,temp);
        if(prev_index==-1 || groups[prev_index]!=groups[current_index])
        {
            temp.add(words[current_index]);
            getOutput(words,groups,current_index,current_index+1,ans,temp);
            temp.remove(temp.size()-1);
        }
    }
    public static void main(String[] args) {
        List<String> ans=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        String words[]={"a","b","c","d"};
        int groups[]={1,0,1,1};
        LUAS obj=new LUAS();
        obj.getOutput(words,groups,-1,0,ans,temp);
        System.out.println(ans);
        // int words_length=words.length;
        // int dp[][]=new int[words_length+1][words_length+1];
        // for(int i=words.length-1;i>=0;i--)
        // {
        //     for(int j=i-1;j>=-1;j--)
        //     {
        //         int not_take=dp[i+1][j+1];
        //         int take=0;
        //         if(j==-1 || groups[j]!=groups[i])
        //         {
        //             take=1+dp[i+1][i+1];
        //         }
        //         dp[i][j+1]=Math.max(not_take,take);
        //     }
        // }
        // for(int i = words_length-1; i>=0; i--)
        // {
        //     for(int j = words_length-1; j>=0 ;j--)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        //         }

    }
}