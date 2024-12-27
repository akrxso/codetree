import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean ch = false;
        int i =2;

        while(true)
        {
            if(i==a)
            {
                break;
            }
            if(a%i==0)
            {
                ch = true;
                break;
            }
            i++;
        }
        if(ch==true)
        {
        System.out.print("C");
        }else
        {
        System.out.print("P");
        }
    }
}