import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a>=90)
        {
            if(b>=95)
            {
                System.out.print(100000);
            }else if(b>=90)
            {
                System.out.print(50000);
            }else
                System.out.print(0);
        }else
            System.out.print(0);
    }
}