import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int avg =0;
        int sum =0;
        while(true)
        {
        int a = sc.nextInt();
        if(a<=20||a>=30)
        {
            break;
        }
        avg++;
        sum +=a;
        }
        System.out.printf("%.2f",(double)sum/avg);
    }
}