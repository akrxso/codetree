import java.util.*;

public class Main {


    static int N;
    static int M;
    static int K;

    static int LIMIT;

    static int[] values;
    static int[] goWith;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        K = kb.nextInt();

        LIMIT = M - 1;

        values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = kb.nextInt();
        }

        goWith = new int[N];
        makeLocation(0);
        System.out.println(max);
    }

    public static void makeLocation(int curIdx) {
        if (curIdx == N) {
            max = Math.max(max, cal());
            return;
        }

        for (int i = 0; i < K; i++) {
            goWith[curIdx] = i;
            makeLocation(curIdx + 1);
        }
    }

    public static int cal() {
        int[] sum = new int[K];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            sum[goWith[i]] = sum[goWith[i]] + values[i];
        }

        for (int i = 0; i < K; i++) {
            if (sum[i] >= LIMIT) {
                cnt++;
            }
        }
        return cnt;
    }
}