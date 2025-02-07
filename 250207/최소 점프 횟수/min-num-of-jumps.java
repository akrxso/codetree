import java.util.*;

public class Main {

    static int N;
    static int target;
    static int[] numbers;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        N = kb.nextInt();
        target = N - 1;
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = kb.nextInt();
        }

        goTo(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void goTo(int curIdx, int cnt) {
        if (curIdx == target) {
            min = Math.min(min, cnt);
            return;
        }

        if (curIdx > target) {
            return;
        }

        int availableValue = numbers[curIdx];
        for (int i = 1; i <= availableValue; i++) {
            goTo(curIdx + i, cnt + 1);
        }
    }
}