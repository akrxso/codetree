import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum =0;
        for(int i = a;i<=b;i++)
        {
            if(i%6==0&&i%8!=0)
            {
                sum +=i;
            }
        }
        System.out.print(sum);
        // 여기에 코드를 작성해주세요.
    }
}