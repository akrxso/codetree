import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //감기 y, 없으면 n
        int arr[] = new int[4];
        for(int i=0;i<3;i++)
        {
            char a = sc.next().charAt(0);
            int n = sc.nextInt();
            if(a=='Y'&&n>=37)
            {
                arr[0]++;
            }else if(a=='N'&&n>=37)
            {
                arr[1]++;
            }else if(a=='Y'&&n<37)
            {
                arr[2]++;
            }else{
                arr[3]++;
            }
        }
        for(int i=0;i<4;i++)
        {
            System.out.print(arr[i]+" ");
        }
        if(arr[0]>=2)
        {
            System.out.print("E");
        }
    }
}