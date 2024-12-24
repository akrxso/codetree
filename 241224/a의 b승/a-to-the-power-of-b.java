import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int mult =1;
        for(int i=0;i<b;i++)
        {
            mult = mult * a;
        }
        System.out.print(mult);
    }
}