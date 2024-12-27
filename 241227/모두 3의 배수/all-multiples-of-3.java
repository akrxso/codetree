import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean ch = true;
        for(int i =0;i<5;i++)
        {
        int a = sc.nextInt();
        if(a%3==0)
        { 
            ch = false; //3의 배수면 1
            break;
        }
        }
        if(ch == true)
        {
        System.out.print(0);
        }else{
        System.out.print(1);
        }
    }
}