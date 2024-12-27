import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean ch = false;
        for(int i=2;i<a;i++)
        {
            if(a%i==0)
            {
                ch = true;
            }
        }

        if(ch==true)
        {
        System.out.print("C");
        }else{
        System.out.print("N");
        }
    }
}