import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String c = sc.next();
        //a>b a가 크면 a>c? a:c
        int min = a.length();
        if(b.length()<min)
        {
            min = b.length();
        }
        if(c.length()<min)
        {
            min = c.length();
        }
        int max = a.length();
        if(b.length()>max)
        {
            max = b.length();
        }
        if(c.length()>max)
        {
            max = c.length();
        }
        System.out.print(max-min);
    }
}