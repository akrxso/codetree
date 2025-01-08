import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char arr[] = {'L','E','B','R','O','S'};
        char a = sc.next().charAt(0);
        int ch = -1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == a)
            {
                ch = i;
            }
        }
        if(ch == -1)
        {
        System.out.print("None");
        }else
            System.out.print(ch);
    }
}