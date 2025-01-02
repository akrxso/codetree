import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //7 5 3 1 3 5 7
        for(int i=1;i<n+1;i++)
        {
        for(int k=0;k<i-1;k++)
        {
            System.out.print("  ");

        }
        for(int j=0;j<-2*i+9;j++)
        {
            System.out.print("* ");
        }
        System.out.println();
        }

        //3 5 7
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i;j++)
            {
            System.out.print("  ");
            }
            for(int k=0;k<2*(i+1)+1;k++)
            {
              System.out.print("* ");
        }
        System.out.println();
        }
    }
}