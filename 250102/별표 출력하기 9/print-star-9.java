import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n-1;j++)
            {
                System.out.print("  ");
            }
            for(int k=0;k<2*i+1;k++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}