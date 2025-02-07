import java.util.*;

public class Main {

    static int[][] grid;
    static int[][] directionGrid;

    static int[][] direction = {
        {},
        {-1, 0},
        {-1, 1},
        {0, 1},
        {1, 1},
        {1, 0},
        {1, -1},
        {0, -1},
        {-1, -1}
    };

    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        
        grid = new int[N][N];
        directionGrid = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                directionGrid[r][c] = kb.nextInt();
            }
        }
        int curRow = kb.nextInt() - 1;
        int curCol = kb.nextInt() - 1;

        goTravel(curRow, curCol, 0);
        System.out.println(max);
    }

    static void goTravel(int curRow, int curCol, int cnt) {

        max = Math.max(max, cnt);
        
        int dir = directionGrid[curRow][curCol];
        int[] d = direction[dir];

        for (int i = 1; i <= N; i++) {
            int nextRow = curRow + d[0] * i;
            int nextCol = curCol + d[1] * i;

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
            if (grid[nextRow][nextCol] <= grid[curRow][curCol]) continue;

            goTravel(nextRow, nextCol, cnt + 1);
        }
    }
}