// package algorithm.codetree.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAX_N = 1_000;
    static int[] arr = new int[MAX_N];
    static int[] dp = new int[MAX_N];
    static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        // 초기 DP 세팅
        Arrays.fill(dp, 0, N + 1, -1);
        dp[0] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == -1) continue;

                if (i <= j + arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        // for (int i = 0; i < N; i++) {
        //     System.out.print(dp[i] + " ");
        // }
    }
}
