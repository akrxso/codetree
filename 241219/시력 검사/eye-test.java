import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double left = sc.nextDouble();
        double right = sc.nextDouble();
        if(left>=1.0 && right>=1.0)
        {
            System.out.print("High");
        }else if(left>=0.5 && right>=0.5)
        {
            System.out.print("Middle");
        }else
            System.out.print("Low");

        
    }
}