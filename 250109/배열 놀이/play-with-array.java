import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int q = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i =0;i<q;i++)
        {
            //1 a
            int a =sc.nextInt();
            int c =0;
            if(a==1)
            {
                int b = sc.nextInt();
                System.out.println(arr[b-1]);
                
            }else if(a==2)
            {
                int b = sc.nextInt();
                int cnt =0;
                int c =0;
                for(int j=0;j<n;j++)
                {
                    if(arr[j]==b)
                    {
                        cnt = j;
                        c++;
                        break;
                    }
                }
                if(c!=0)
                {
                System.out.println(cnt+1);
                }else{
                System.out.println(cnt);
                }
            }else{
                int s = sc.nextInt();
                int e = sc.nextInt();
                for(int j=s-1;j<e;j++)
                {
                    System.out.print(arr[j]+" ");
                }
                System.out.println();
            }


        }
        
    }
}