import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int min = a;
        if(min>b){
            min = b;
        }else if(min>c){
            min = c;
        }
        if(a == min)
        {
            System.out.print(1+" ");
        }else
        {
            System.out.print(0+" ");
        }
        if(a == b && b == c)
        {
            System.out.print(1);
        }else{
            System.out.print(0);
        }
    }
}