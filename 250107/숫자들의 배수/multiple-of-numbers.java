    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int cnt =0;
            ArrayList<Integer> arr =new ArrayList<>();
            int num =sc.nextInt();
            for(int i=0;;i++)
            {
                arr.add(num*(i+1));
                if(arr.get(i)%5==0)
                {
                    cnt++;
                }
                if(cnt==2)
                {
                    break;
                }
            }
            for(int i=0;i<arr.size();i++)
            {
            System.out.print(arr.get(i)+" ");

            }
        }
    }