import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        if(w>=3000)
        {
            System.out.print("book");
        }else if (w>=1000)
        {
            System.out.print("mask");
        }else if (w>=500)
        {
            System.out.print("pen");
        }else
        {
            System.out.print("no");
        }
    }
}