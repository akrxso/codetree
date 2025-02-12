import java.util.*;

public class Main {

    static final int MAX = 100;

    static int N;
    static int M;
    static int[][] grid = new int[MAX][MAX];
    static boolean[][] visited = new boolean[MAX][MAX];

    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        visited[0][0] = true;
        dfs(0, 0);

        if (visited[N - 1][M - 1]) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }

    static void dfs(int row, int col) {

        for (int d = 0; d < 2; d++) {
            int nextRow = row + dr[d];
            int nextCol = col + dc[d];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue;
            if (visited[nextRow][nextCol]) continue;
            if (grid[nextRow][nextCol] == 0) continue;

            visited[nextRow][nextCol] = true;
            dfs(nextRow, nextCol);
        }
    }
}