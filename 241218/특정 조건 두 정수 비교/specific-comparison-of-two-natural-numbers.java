import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(a<b?1:0);
        System.out.print(" ");
        System.out.print(a==b?1:0);
    }
}