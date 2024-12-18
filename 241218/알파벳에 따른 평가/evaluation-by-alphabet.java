import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char w = sc.next().charAt(0);
        if(w=='S')
        {
            System.out.print("Superior");
        }else if(w=='A')
        {
            System.out.print("Excellent");
        }else if(w=='B')
        {
            System.out.print("Good");
        }else if(w=='C')
        {
            System.out.print("Usually");
        }else if(w=='D')
        {
            System.out.print("Effort");
        }else
        {
            System.out.print("Failure");
        }
    }
}