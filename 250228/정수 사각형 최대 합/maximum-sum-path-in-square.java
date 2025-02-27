import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        N = kb.nextInt();
        arr = new int[N][N];
        dp = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                arr[r][c] = kb.nextInt();
            }
        }

        // 초기 세팅
        dp[0][0] = arr[0][0];
        for (int c = 1; c < N; c++) {
            dp[0][c] = dp[0][c - 1] + arr[0][c];
        }
        for (int r = 1; r < N; r++) {
            dp[r][0] = dp[r - 1][0] + arr[r][0];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                dp[r][c] = Math.max(dp[r - 1][c] + arr[r][c], dp[r][c - 1] + arr[r][c]);
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}