import java.util.*;
public class Search_Rotated {
    public int searchBS(int arr[],int N,int X)
    {
        
    }
    public static void main(String[] args) {
        Search_Rotated obj = new Search_Rotated();
        Scanner rs = new Scanner(System.in);
        System.out.println("Size N");
        int N = rs.nextInt();
        int arr[] = new int[N];
        System.out.println("Enter elements");
        for(int i = 0;i < N;i++)
        {
            arr[i] = rs.nextInt();
        }
        System.out.println("Enter target");
        int X = rs.nextInt();
        System.out.print(obj.searchBS(arr,N,X));
    }
}
