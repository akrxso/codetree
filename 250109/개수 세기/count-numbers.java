import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int cnt=0;
        for(int i=0;i<n;i++){
            int b = sc.nextInt();
            if(b == a)
            {
                cnt++;
            }
        }        
        System.out.print(cnt);
    }
}