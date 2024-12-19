import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Aage = sc.nextInt();
        char Asex = sc.next().charAt(0);
        int Bage = sc.nextInt();
        char Bsex = sc.next().charAt(0);
        System.out.print(Aage>=19&&Asex=='M' || Bage>=19&&Bsex=='M' ?
        1:0 );
    }
}