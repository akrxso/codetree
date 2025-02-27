import java.util.Scanner;

public class Main {

    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n, m, row, col;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] nextGrid = new int[MAX_N][MAX_N];

    static boolean inRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    static void expand(int r, int c, int dist) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int d = 0; d < DIR_NUM; d++) {
            int nextRow = r + dr[d] * dist;
            int nextCol = c + dc[d] * dist;
            if (inRange(nextRow, nextCol)) {
                nextGrid[nextRow][nextCol] = 1;
            }
        }
    }

    static void simulate(int dist) {
        // Step1. nextGrid의 값을 0으로 초기화한다.
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                nextGrid[r][c] = 0;
            }
        }

        // Step2. 폭탄을 던지는 시뮬레이션을 진행한다.
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] > 0) {
                    expand(r, c, dist);
                }
            }
        }

        // Step 3. nextGrid 값을 grid로 업데이트 한다.
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (nextGrid[r][c] > 0) {
                    grid[r][c] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        row = kb.nextInt() - 1;
        col = kb.nextInt() - 1;

        grid[row][col] = 1;

        int dist = 1;
        for (int i = 0; i < m; i++) {
            simulate(dist);
            dist *= 2;
        }
        
        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans += grid[r][c];
            }
        }
        System.out.println(ans);
    }
}
