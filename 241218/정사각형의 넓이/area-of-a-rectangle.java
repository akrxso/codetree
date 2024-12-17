import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        System.out.println(w*w);
        if(w<5)
            System.out.print("tiny");
    }
}