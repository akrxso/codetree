import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int sum =0;
        int b=0;
        for(int i=1;i<=100;i++)
        {
            sum+=i;
            if(sum>=a)
            {
                b=i;
                break;
            }
        }
        System.out.print(b);
    }
}