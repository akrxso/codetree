import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double arr[] = new double[n];
        double sum =0;
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextDouble();
            sum+=arr[i];
        }
        System.out.printf("%.1f \n",sum/n);
        if(sum/n>=4.0)
        {
        System.out.print("Perfect");
        }else if(sum/n>=3.0)
        {
        System.out.print("Good");
        }else{
        System.out.print("Poor");
        }
    }
}