import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mult =1;
        for(int i=a;i<=b;i++)
        {
            mult *=i;
        }
        System.out.print(mult);
    }
}