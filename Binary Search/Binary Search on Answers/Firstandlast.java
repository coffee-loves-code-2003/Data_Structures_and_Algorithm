import java.util.*;
public class Firstandlast
{
    public int getFirst(int arr[],int N,int x)
    {
        int low = 0;
        int high = N-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high)
        {
            int mid = (low + high) /2;
            if(arr[mid] == x)
            {
                ans = Math.min(ans,mid);
                high = mid -1;
            }
            else if(arr[mid] > x)
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        if(ans == Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
    public int getLast(int arr[],int N,int x)
    {
        int low = 0;
        int high = N-1;
        int ans = Integer.MIN_VALUE;
        while(low <= high)
        {
            int mid = (low + high) /2;
            if(arr[mid] == x)
            {
                ans = Math.max(ans,mid);
                low = mid +1;
            }
            else if(arr[mid] > x)
            {
                high = mid - 1;
            }
            else 
            {
                low = mid + 1;
            }
        }
        if(ans == Integer.MIN_VALUE)
        {
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Firstandlast obj = new Firstandlast();
        Scanner rs = new Scanner(System.in);
        System.out.println("Size of the array");
        int N = rs.nextInt();
        int arr[] = new int[N];
        System.out.println("Elements in the array");
        for(int i = 0;i < N;i++)
        {
            arr[i] = rs.nextInt();
        }
        System.out.println("Enter x");
        int x = rs.nextInt();
        System.out.println(obj.getFirst(arr,N,x));
        System.out.println(obj.getLast(arr,N,x));
        rs.close();
    }
}