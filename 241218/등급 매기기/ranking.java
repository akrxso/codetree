import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        if(w>=90)
        {
            System.out.print("A");
        }else if(w>=80)
        {
            System.out.print("B");
        }else if(w>=70)
        {
            System.out.print("C");
        }else if(w>=60)
        {
            System.out.print("D");
        }else
            System.out.print("F");
    }
}