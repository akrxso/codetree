import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[10];
        for(int i=0;i<n;i++)
        {
            int a = sc.nextInt();
            arr[a]++;
        }
        for(int i=1;i<=9;i++)
        {
        System.out.println(arr[i]);
        }
    }
}