import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 1_000;
    static final int LIMIT = 1_000;
    static int[] arr = new int[MAX_N + 1];
    static int[] dp = new int[MAX_N + 1];

    static int N;

    static void init() {
        // 현재 위치에서 시작할 때에는 dp 값이 1이 되므로 초기 세팅은 1이다.
        Arrays.fill(dp, 0, N + 1, 1);
        arr[0] = 0;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            arr[i] = kb.nextInt();
        }
        init();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
