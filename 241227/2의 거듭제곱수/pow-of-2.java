import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i =1;
        while(a!=2)
        {
            a=a/2;
            i++;
        }
        System.out.print(i);
    }
}