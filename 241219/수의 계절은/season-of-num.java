import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a<3)
        {
        System.out.print("Winter");
        }else if(a<6)
        {
            System.out.print("Spring");
        }else if(a<9)
        {
            System.out.print("Summer");
        }else if(a<12)
        {
            System.out.print("Fall");
        }else
        System.out.print("Winter");
    }
}