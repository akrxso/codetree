import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int max = arr[0];
        for(int i=0;i<10;i++)
        {
            arr[i] = sc.nextInt();
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        System.out.print(max);
    }
}