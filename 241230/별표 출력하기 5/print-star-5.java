import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=n-i;j>0;j--)
            {
                //* 두개 찍기
                for(int k=n-i;k>0;k--)
                {
                System.out.print("*");
                }
                System.out.print(" ");
            }
        System.out.println();
        }
    }
}