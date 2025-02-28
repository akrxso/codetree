import java.util.*;

public class Main {

    static final int DIR_NUM = 4;
    static final int MAX_N = 500;

    // 변수 선언
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static List<Cell> cells = new ArrayList<>();
    static int ans = 0;

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = sc.nextInt();
            }
        }

        // 각 칸에 적혀있는 정수값 기준으로
        // 오름차순으로 되도록 칸의 위치들을 정렬한다
        // 편하게 정렬하기 위해 (칸에 적혀 있는 값, 행 위치, 열 위치) 순으로 넣어준다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                cells.add(new Cell(grid[r][c], r, c));
            }
        }

        Collections.sort(cells, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.num - o2.num;
            }
        });

        // 처음 DP 값들은 전부 1로 초기화한다.
        // (해당 칸에서 시작하는 경우이므로)
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                dp[r][c] = 1;
            }
        }

        // 정수값이 작은칸부터 순서대로 보며,
        // 4방향에 대한 dp 값을 갱신해준다.
        for (int i = 0; i < cells.size(); i++) {
            int r = cells.get(i).r;
            int c = cells.get(i).c;
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            // 인접한 4칸에 대해 갱신을 진횅한다.
            for (int d = 0; d < DIR_NUM; d++) {
                int nextRow = r + dr[d];
                int nextCol = c + dc[d];
                if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] > grid[r][c]) {
                    dp[nextRow][nextCol] = Math.max(dp[nextRow][nextCol], dp[r][c] + 1);
                }
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                ans = Math.max(ans, dp[r][c]);
            }
        }
        System.out.println(ans);
    }

    static class Cell {
        int num, r, c;
        public Cell(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }
    }
}
