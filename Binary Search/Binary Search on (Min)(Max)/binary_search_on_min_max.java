import java.util.*;
public class binary_search_on_min_max
{
    public boolean checker(int[] arr,int mid,int arr_length,int d)
    {
        int prev = arr[0];
        for(int i = 1;i < arr_length;i++)
        {
            prev = Math.max(prev + mid, arr[i]);
            if(prev <= arr[i]+d)
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner rs = new Scanner(System.in);
        int N = rs.nextInt();
        int arr[] = new int[N];
        binary_search_on_min_max obj = new binary_search_on_min_max();
        for(int i = 0;i < N;i++)
        {
            arr[i] = rs.nextInt();
        }
        int d = rs.nextInt();
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(arr);
        while(low <= high)
        {
            int mid = (low+high)/2;
            if(obj.checker(arr,mid,N,d))
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
}