import java.util.*;
public class Knight_Chessboard
{
    public double getOutput(int n, int k, int row, int column, double[][][] dp)
    {
        if(k < 0)
        {
            return 1.0;
        }
        if(row < 0 || row >=n || column < 0 || column >=n)
        {
            return 0;
        }
        if(dp[row][column][k]!=-1.0)
        {
            return dp[row][column][k];
        }
        double move_1 = getOutput(n, k-1, row - 2, column + 1, dp)*(1.0/8.0);
        double move_2 = getOutput(n, k-1, row - 2, column - 1, dp)*(1.0/8.0);
        double move_3 = getOutput(n, k-1, row - 1, column - 2, dp)*(1.0/8.0);
        double move_4 = getOutput(n, k-1, row + 1 ,column - 2, dp)*(1.0/8.0);
        double move_5 = getOutput(n, k-1, row + 2 ,column - 1, dp)*(1.0/8.0);
        double move_6 = getOutput(n, k-1, row + 2 ,column + 1, dp)*(1.0/8.0);
        double move_7 = getOutput(n, k-1, row + 1 ,column + 2, dp)*(1.0/8.0);
        double move_8 = getOutput(n, k-1, row - 1 ,column + 2, dp)*(1.0/8.0);
        return dp[row][column][k]=move_1+move_2+move_3+move_4+move_5+move_6+move_7+move_8;

    }
    public static void main(String[] args) {
        Scanner rs=new Scanner(System.in);
        int n = rs.nextInt();
        int k =rs.nextInt();
        double dp[][][]=new double[n][n][k+1];
        for(int i = 0; i < n; i++ )
        {
            for(int j = 0; j < n; j++)
            {
                for(int j1 = 0 ; j1 <= k ;j1++)
                {
                    dp[i][j][j1]=-1.0;
                }
            }
        }
        int row = rs.nextInt();
        int column = rs.nextInt();
        Knight_Chessboard obj=new Knight_Chessboard();
        System.out.print(obj.getOutput(n, k, row, column,dp));
    }
}