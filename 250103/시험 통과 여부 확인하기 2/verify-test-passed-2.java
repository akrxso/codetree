import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n*4];
        int cnt=0;
        for(int i=0;i<n;i++){
            double sum =0;
            for(int j=0;j<4;j++)
            {
                arr[i]=sc.nextInt();
                sum += arr[i];
            }
            if(sum/4>=60)
            {
                System.out.println("pass");
                cnt++;
            }else{
                System.out.println("fail");
            }
        }
        System.out.print(cnt);
        // Please write your code here.
    }
}