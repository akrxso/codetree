import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        if(y%4==0)
        {
            if(y%100==0 && y%400!=0)
            {
            System.out.print("false");
            }else
                System.out.print("true");
        }else
        {
            System.out.print("false");

        }
        //100으로 나누어 떨어지되 400으로 나누어 떨어지지 않는 해
    }
}