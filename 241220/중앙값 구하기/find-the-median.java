import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        //2 1 4
        if(a>b)
        {
            if(a>c)
            {
                System.out.print(b>c?b+" ":c+" ");    
            }
            else{
                System.out.print(a+" ");
            }
        }
        else if(c>a)
        {
            if(c>b)
            {
                System.out.print(a>b?a+" ":b+" ");    
            }
            else{
                System.out.print(c+" ");
            }
        }
        else if(b>a)
        {
            if(b>c)
            {
                System.out.print(a>c?a+" ":c+" ");    
            }
            else{
                System.out.print(c+" ");
            }
        }

    }
}