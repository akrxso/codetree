import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[7];
        for(int i=0;i<10;i++)
        {
        int n = sc.nextInt();
        arr[n]++;
        }
        for(int i=1;i<7;i++)
        {
        System.out.println(i+" - "+arr[i]);
        }
    }
}