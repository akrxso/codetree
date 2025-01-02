import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //왼쪽 가운데 오른쪽

        for(int i=0; i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                System.out.print("*");
            }
            //가운데 0,1,2,...
            for(int k=0;k<i;k++)
            {
                System.out.print("  ");
            }
            for(int j=i;j<n;j++)
            {
                System.out.print("*");
            }
        System.out.println();
        }
    }
}