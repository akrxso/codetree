 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int arr1[] = new int[a1];
        int arr2[] = new int[b1];
        int k=0;
        for(int i=0;i<a1;i++)
        {
            arr1[i]=sc.nextInt();
        }
        for(int i=0;i<b1;i++)
        {
            arr2[i]=sc.nextInt();
        }
        for(int i=0;i<a1;i++)
        {
            if(arr1[i]==arr2[0])
            {
                k=i; // k =2
            }
        }

        int b=0;
        boolean t =true;
        for(;k<=b1;k++)
        {
            if(arr1[k]!=arr2[b])
            {
                System.out.println("No");
                // System.out.println(arr2[b]);
                t = false;
                break;
            }
            // System.out.println(arr2[b]);
            b++;
        }
        if(t)
        {
            System.out.println("Yes");
        }
    }
}