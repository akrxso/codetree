import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=n;i>1;i--)
        {
            for(int j=n;j>n-i;j--)
            {
                System.out.print("* ");

            }
        System.out.println();
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=n;j>n-i;j--)
            {
                System.out.print("* ");

            }
        System.out.println();
        }
    }
}