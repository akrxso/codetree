import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        boolean ch = false;
        for(int i =a;i<=b;i++)
        {
            if(i%c==0)
            {
                ch = true;
            }
        }
        if(ch == true)
        {
        System.out.print("NO");
        }
        else{
        System.out.print("YES");
        }
    }
}