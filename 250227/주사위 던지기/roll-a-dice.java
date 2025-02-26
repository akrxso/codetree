import java.util.*;

public class Main {

    static final int MAX_N = 100;
    static final int MAX_M = 10_000;
    static final int SEVEN = 7;

    static int[][] grid = new int[MAX_N][MAX_N];
    static String[] directions = new String[MAX_M];
    static int[][] dice = new int[3][3];

    static int N;
    static int M;
    static int startRow;
    static int startCol;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        startRow = kb.nextInt() - 1;
        startCol = kb.nextInt() - 1;

        for (int i = 0; i < M; i++) {
            directions[i] = kb.next();
        }
        // 주사위 세팅
        dice[1][1] = 6;
        dice[1][0] = 4;
        dice[1][2] = 3;
        dice[0][1] = 5;
        dice[2][1] = 2;

        int currRow = startRow;
        int currCol = startCol;
        grid[currRow][currCol] = dice[1][1];

        for (int k = 0; k < M; k++) {
            String direction = directions[k];
            if ("L".equals(direction)) {
                int nextRow = currRow + dr[0];
                int nextCol = currCol + dc[0];
                if (!inRange(nextRow, nextCol)) continue;

                // 다이스 바꿔주고
                int ops = SEVEN - dice[1][1];
                for (int i = 2; i > 0; i--) {
                    dice[1][i] = dice[1][i - 1];
                }
                dice[1][0] = ops;
                // 현재 위치 바꿔주고
                currRow = nextRow;
                currCol = nextCol;
                // 현재 위치에 바닥 다이스 값을 적어준다.
                grid[currRow][currCol] = dice[1][1];
            }
            if ("R".equals(direction)) {
                int nextRow = currRow + dr[1];
                int nextCol = currCol + dc[1];
                if (!inRange(nextRow, nextCol)) continue;

                // 다이스 바꿔주고
                int ops = SEVEN - dice[1][1];
                for (int i = 0; i < 2; i++) {
                    dice[1][i] = dice[1][i + 1];
                }
                dice[1][2] = ops;
                // 현재 위치 바꿔주고
                currRow = nextRow;
                currCol = nextCol;
                // 현재 위치에 바닥 다이스 값을 적어준다.
                grid[currRow][currCol] = dice[1][1];
            }
            if ("U".equals(direction)) {
                int nextRow = currRow + dr[2];
                int nextCol = currCol + dc[2];
                if (!inRange(nextRow, nextCol)) continue;

                int ops = SEVEN - dice[1][1];
                for (int i = 2; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }
                dice[0][1] = ops;
                currRow = nextRow;
                currCol = nextCol;
                grid[currRow][currCol] = dice[1][1];
            }
            if ("D".equals(direction)) {
                // printDice();
                // System.out.println("-----");
                int nextRow = currRow + dr[3];
                int nextCol = currCol + dc[3];
                if (!inRange(nextRow, nextCol)) continue;

                int ops = SEVEN - dice[1][1];
                for (int i = 0; i < 2; i++) {
                    dice[i][1] = dice[i + 1][1];
                }
                dice[2][1] = ops;
                currRow = nextRow;
                currCol = nextCol;
                grid[currRow][currCol] = dice[1][1];

                // printDice();
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += grid[i][j];
            }
        }
        System.out.println(cnt);
    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }

    static void printDice() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(dice[i][j] + " ");
            }
            System.out.println();
        }
    }
}