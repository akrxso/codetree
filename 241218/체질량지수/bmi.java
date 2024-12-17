import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        double b =(double)(10000*w)/(h*h);
        System.out.printf("%d \n",(int)b);
        if(b>25)
        {
            System.out.print("Obesity");
        }
        // 여기에 코드를 작성해주세요.
    }
}