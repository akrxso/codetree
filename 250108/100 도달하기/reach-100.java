import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int a1=1;
        arr.add(a1);
        int a2 = sc.nextInt();
        arr.add(a2);
        int temp=0;
        while(temp<100)
        {
            temp = a2+a1;
            arr.add(temp);
            a1 = a2;
            a2 = temp;
        }
        for(int i=0;i<arr.size();i++)
        {
        System.out.print(arr.get(i)+" ");
        }
    }
}