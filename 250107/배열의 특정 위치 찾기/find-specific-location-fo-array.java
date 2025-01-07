import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        int sum =0;
        double avg=0;
        int cnt=0;
        int a=0;
        for(int i=0;i<10;i++)
        {
            a++;
            arr[i]=sc.nextInt();
            if(i%2!=0)
            {
                sum+=arr[i];
            }
            if(a%3==0)
            {
                avg+=arr[i];
                cnt++;
            }
        }
        System.out.print(sum+" ");
        System.out.printf("%.1f",avg/cnt);
        // Please write your code here.
    }
}