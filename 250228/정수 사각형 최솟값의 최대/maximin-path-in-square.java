import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];
    
    static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        //초기 세팅
        dp[0][0] = grid[0][0];
        for (int r = 1; r < N; r++) {
            dp[r][0] = Math.min(dp[r - 1][0], grid[r][0]);
        }
        for (int c = 1; c < N; c++) {
            dp[0][c] = Math.min(dp[0][c - 1], grid[0][c]);
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                dp[r][c] = Math.max(Math.min(dp[r - 1][c], grid[r][c]), Math.min(dp[r][c - 1], grid[r][c]));
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}