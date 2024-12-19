import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mathA = sc.nextInt();
        int enA = sc.nextInt();
        int mathB = sc.nextInt();
        int enB = sc.nextInt();

        if(mathA>mathB)
        {
            System.out.print("A");
        }else if(mathA<mathB)
        {
            System.out.print("B");
        }else
        {
            System.out.print(enA>enB?"A":"B");
        }
    }
}