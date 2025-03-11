import java.util.Scanner;

public class Main {
    static final int MAX = 50;

    static int[][] grid = new int[MAX][MAX];
    static int[][] dp = new int[MAX][MAX];
    static int ROW;
    static int COL;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ROW = kb.nextInt();
        COL = kb.nextInt();

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        init();
        dp[0][0] = 1;

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (dp[r][c] != -1) {
                    int startRow = r + 1;
                    int startCol = c + 1;

                    for (int nextRow = startRow; nextRow < ROW; nextRow++) {
                        for (int nextCol = startCol; nextCol < COL; nextCol++) {
                            if (grid[r][c] < grid[nextRow][nextCol]) {
                                dp[nextRow][nextCol] = Math.max(dp[nextRow][nextCol], dp[r][c] + 1);
                            }
                        }
                    }
                }
            }
        }

//        printDp();

        int max = Integer.MIN_VALUE;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                max = Math.max(max, dp[r][c]);
            }
        }
        System.out.println(max);




    }

    static void printDp() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                System.out.print(dp[r][c] + " ");
            }
            System.out.println();
        }
    }

    static void init() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                dp[r][c] = -1;
            }
        }
    }
}
