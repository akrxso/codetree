import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mult = 1;
        int i=1;
        for(i=1;i<=10;i++)
        {
            mult*=i;
            if(mult>=n)
            {
                break;
            }
        }
        System.out.print(i);
    }
}