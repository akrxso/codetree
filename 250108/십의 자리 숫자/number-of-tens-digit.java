import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0;
        int arr[] = new int[10];
        do
        {
        n = sc.nextInt();
        if(n>=10)
        {
            n = n/10;
            arr[n]++;
        }
        }while(n!=0);
        for(int i=1;i<10;i++)
        {
        System.out.println(i+" - "+arr[i]);
        }
    }
}