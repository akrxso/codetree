import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a%2!=0)
        {
            a+=3;
        }
        if(a%3 == 0)
        {
            System.out.print(a/3);
        }else
        {
            System.out.print(a);
        }
    }
}