import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;
        while(i<3)
        {
            int a = sc.nextInt();
            if(a%2==0)
            {
                a= a/2;
                System.out.println(a);
                i++;
            }
        }
    }
}