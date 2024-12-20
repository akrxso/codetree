import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int b = a;
        for(int i=0;i<=a;i++)
        {
            b+=n;
            System.out.println(b);
        }
    }
}