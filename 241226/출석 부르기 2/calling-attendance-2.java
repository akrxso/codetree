import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        int a = sc.nextInt();
        if(a==1)
        {
        System.out.println("John");
            
        }else if(a==2)
        {
        System.out.println("Tom");

        }else if(a==3)
        {
        System.out.println("Paul");
            
        }else if(a==4)
        {
        System.out.println("Sam");
        }else{
        System.out.println("Vacancy");
        break;

        }
        }
    }
}