import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean a =true;
        int arr[] = new int[11];
        while(a)
        {
            int n = sc.nextInt();
            if(n==0)
            {
                a = false;
            }
            if(n>=10)
            {
                n = n/10;
                arr[n]++;
            }

        }
        for(int i=10;i>0;i--)
        System.out.println(i*10+" - "+arr[i]);
    }
}