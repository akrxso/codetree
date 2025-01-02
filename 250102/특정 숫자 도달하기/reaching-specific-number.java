import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int sum =0;
        int a=0;
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
            if(arr[i]>=250)
            {
                break;
            }else
            {
                sum+=arr[i];
                a=i;
            }
        }
        System.out.print(sum+" ");
        System.out.printf("%.1f",(double)sum/(a+1));
    }
}