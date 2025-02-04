import java.util.*;

public class Main {

    static final int MAX_NUMBER = 4;

    static int N;
    static int[] arr;
    static int count;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        arr = new int[N];
        permutation(0);

        System.out.println(count);
    }

    public static void permutation(int currIdx) {
        // 기저 조건
        if (currIdx == N) {
            if (isBeautiful()) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= MAX_NUMBER; i++) {
            arr[currIdx] = i;
            permutation(currIdx + 1);
        }
    }

    public static boolean isBeautiful() {
        int currNum = arr[0];
        int sum = 1;

        for (int i = 1; i < N; i++) {
            if (currNum == arr[i]) { // 만약 같다면
                sum++;
            }
            else { // 같지 않다면
                if (sum % currNum != 0) { // 아름다운 숫자가 아니면
                    return false;
                }
                currNum = arr[i];
                sum = 1;
            }
        }
        if (sum % currNum != 0) {
            return false;
        }

        // for (int i = 0; i < N; i++) {
        //     System.out.print(arr[i]);
        // }
        // System.out.println();
        
        return true;
    }
}