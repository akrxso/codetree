import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            if(i%2==0||i%3==0||i%5==0)
            {
                continue;
            }
            count++;

        }
        System.out.print(count);
    }
}