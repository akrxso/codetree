import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt=0; //윤년
        for(int i=1;i<=n;i++)
        {
            //4로 나누어떨어지면 윤년
            if(i%4==0)
            {
                if(i%100==0&&(i%400!=0))
                {
                    continue;
                }
                cnt++;

            }
            //100으로 나눠지는데 400으로 나누어 떨어지지 않으면 평년
        }
        System.out.print(cnt);
    }
}