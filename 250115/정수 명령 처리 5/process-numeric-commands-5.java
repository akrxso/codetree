import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        boolean ch = true;
        ArrayList<Integer> arr = new ArrayList<>();
        while(ch)
        {
            String s = sc.next();
            a--;
            if(a==0)
            {
                ch = false;
            }

            if(s.equals("push_back"))
            {
                int b = sc.nextInt();
                arr.add(b);
            }else if(s.equals("get"))
            {
                int b = sc.nextInt();
                arr.get(b-1);
                System.out.println(arr.get(b-1));
            }else if(s.equals("size"))
            {
                System.out.println(arr.size());
            }else{
                arr.remove(arr.size()-1);
            }
        }
        // Please write your code here.
    }
} 