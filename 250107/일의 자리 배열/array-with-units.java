import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(a+" "+b+" ");
        for(int i=0;i<8;i++)
        {
            int temp = a + b;
            System.out.print(temp%10+ " ");
            a = b;
            b = temp;
        }
    }
}