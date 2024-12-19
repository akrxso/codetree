import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m1 = 28;
        int m2 = 30;
        int m3 = 31;
        if(a <8)
        {
            if(a%2==0&&a!=2)
            {
                System.out.print(m2);
            }else if(a==2){
                System.out.print(m1);
            }
            else{
                System.out.print(m3);
            }
        }else{
            if(a%2!=0)
            {
                System.out.print(m2);
            }else{
                System.out.print(m3);
            }
        }
    }
}