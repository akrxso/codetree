import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = n;
        int min = n;
        while(true)
        {
        n = sc.nextInt();
        if(n==999||n==-999)
        {
            break;
        }
        if(n>max)
            max = n;
        if(n<min)
        {
            min = n;
        }
        }
        System.out.print(max+" "+min);
    }
}