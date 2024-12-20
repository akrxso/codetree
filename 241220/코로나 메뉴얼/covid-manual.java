import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char as = sc.next().charAt(0);
        int at = sc.nextInt();
        char bs = sc.next().charAt(0);
        int bt = sc.nextInt();
        char cs = sc.next().charAt(0);
        int ct = sc.nextInt();
        //위급상황이라면 E를, 그렇지 않다면 N을 출력합니다.
        int count =0;
        if(as=='Y'&&at>=37)
        {
            count++:
        }
        if(bs=='Y'&&bt>=37)
        {
            count++:
        }
        if(cs=='Y'&&ct>=37)
        {
            count++:
        }
        
        System.out.print(count>=2?"E":"N");
    }
}