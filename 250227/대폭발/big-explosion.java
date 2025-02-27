import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static int[][] grid = new int[MAX_N][MAX_N];

    static int n;
    static int m;
    static int row;
    static int col;
    static Set<String> bombs = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        row = kb.nextInt() - 1;
        col = kb.nextInt() - 1;

        bombs.add(convert(row, col));

        for (int t = 1; t <= m; t++) {
            int value = 1;
            int cnt = t - 1;
            for (int i = 0; i < cnt; i++) {
                value *= 2;
            }

            Set<String> nextBombs = new HashSet<>(bombs);
            // System.out.println("[bombs] :" + bombs);
            // System.out.println(t + "] before : " + nextBombs);
            // System.out.println("value : " + value);

            for (String bomb : bombs) {
                String[] s = bomb.split(" ");
                int curRow = Integer.valueOf(s[0]);
                int curCol = Integer.valueOf(s[1]);

                // System.out.println(bomb + " -> " + curRow + " & " + curCol);

                for (int d = 0; d < 4; d++) {
                    int nextRow = curRow + (dr[d] * value);
                    int nextCol = curCol + (dc[d] * value);

                    // 범위 안이면
                    if (inRange(nextRow, nextCol)) {
                        nextBombs.add(convert(nextRow, nextCol));
                    }
                }
            }
            // System.out.println(t + "] after : " + nextBombs);
            bombs = nextBombs;
        }

        // System.out.println(bombs);
        System.out.println(bombs.size());
    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    static String convert(int row, int col) {
        return row + " " + col;
    }
}