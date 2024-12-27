import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while(n<=1000)
        {
            if(n%2==0)
            {
                n = n*3+1;
            }else
            {
                n = n*2+2;
            }
            i++;
        }
        System.out.print(i);
    }
}