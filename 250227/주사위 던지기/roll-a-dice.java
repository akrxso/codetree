import java.util.Scanner;

public class Main {

    static final int DIR_NUM = 4;
    static final int ASCII_NUM = 128;
    static final int MAX_N = 100;
    static final Pair OUT_OF_GRID = new Pair(-1, -1);

    static int n;
    static int m;
    static int row, col;

    static int[][] grid = new int[MAX_N][MAX_N];

    static int u = 1, f = 2, r = 3;

    static boolean inRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    static void simulate(int moveDir) {
        // moveDir 방향으로 굴렸을 때의 격자상의 위치를 구한다.
        Pair nextPos = nextPos(row, col, moveDir);
        // 불리는 것이 불가능하면 패스한다.
        if (nextPos.r == OUT_OF_GRID.r && nextPos.c == OUT_OF_GRID.c) {
            return;
        }

        // 위치를 이동한다
        row = nextPos.r;
        col = nextPos.c;

        // 주사위의 상태를 조정한다.
        if (moveDir == 0) { //오른쪽
            int next_u = 7 - r;
            int next_f = f;
            int next_r = u;
            u = next_u;
            f = next_f;
            r = next_r;
        }
        if (moveDir == 1) { //왼쪽
            int next_u = r;
            int next_f = f;
            int next_r = 7 - u;
            u = next_u;
            f = next_f;
            r = next_r;
        }
        if (moveDir == 2) {// 위쪽
            int next_u = f;
            int next_f = 7 - u;
            int next_r = r;
            u = next_u;
            f = next_f;
            r = next_r;
        }
        if (moveDir == 3) {
            int next_u = 7 - f;
            int next_f = u;
            int next_r = r;
            u = next_u;
            f = next_f;
            r = next_r;
        }

        int down = 7 - u;
        grid[row][col] = down;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        row = kb.nextInt() - 1;
        col = kb.nextInt() - 1;

        int[] dirMapper = new int[ASCII_NUM];
        dirMapper['R'] = 0;
        dirMapper['L'] = 1;
        dirMapper['U'] = 2;
        dirMapper['D'] = 3;

        // 시뮬레이션 진행
        grid[row][col] = 6;
        for (int i = 0; i < m; i++) {
            char charDir = kb.next().charAt(0);

            simulate(dirMapper[charDir]);
        }

        int ans = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                ans += grid[r][c];
            }
        }
        System.out.println(ans);
    }

    static Pair nextPos(int r, int c, int moveDir) {
        int[] dr = new int[] {0, 0, -1, 1};
        int[] dc = new int[] {1, -1, 0, 0};
        int nr = r + dr[moveDir];
        int nc = c + dc[moveDir];

        if (inRange(nr, nc)) {
            return new Pair(nr, nc);
        }
        return OUT_OF_GRID;
    }

    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
