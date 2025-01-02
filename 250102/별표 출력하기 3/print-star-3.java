import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=n-1;i>=0;i--)
        {
            int c =0;
            for(int j=0;j<n-1-i;j++)
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