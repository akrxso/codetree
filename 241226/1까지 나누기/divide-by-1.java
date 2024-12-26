import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        int a=0;
        while(true)
        {
            n = n/i;
            i++;
            a++;
            if(n<=1)
            {
                break;
            }
        }
        System.out.print(a);
    }
}