import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int cnt=0;
        int k=0;
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            if(cnt==3)
            {
                break;
            }
            if(arr[i]==2)
            {
                cnt++;
                k=i;
            }
        }
        System.out.print(k+1);
    }
}