import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static int[][] grid = new int[MAX_N + 2][MAX_N + 2];

    static int n;
    static char[] chars = {'U', 'D', 'L', 'R'};
    static Map<Character, Integer> dr = new HashMap<>();
    static Map<Character, Integer> dc = new HashMap<>();
    static int max = Integer.MIN_VALUE;

    static boolean inRange(int row, int col) {
        return 1 <= row && row <= n && 1 <= col && col <= n;
    }

    static char changeDirection_1(char dir) {
        if ('D' == dir) return 'L';
        if ('L' == dir) return 'D';
        if ('U' == dir) return 'R';
        if ('R' == dir) return 'U';
        return ' ';
    }
    static char changeDirection_2(char dir) {
        if ('D' == dir) return 'R';
        if ('R' == dir) return 'D';
        if ('U' == dir) return 'L';
        if ('L' == dir) return 'U';
        return ' ';
    }

    static void simulate(int row, int col, char dir) {
        // boolean[][] visited = new boolean[n + 2][n + 2];
        // System.out.print(dir + " ");

        int cnt = 0;
        do {
            int nextRow = row + dr.get(dir);
            int nextCol = col + dc.get(dir);
            // 다음장소가 범위 안이면
            if (inRange(nextRow, nextCol)) {
                // 현재 위치를 변경한다.
                row = nextRow;
                col = nextCol;
                cnt++;
                
                // visited[row][col] = true;

                if (grid[row][col] == 1) { // '/' 이면
                    dir = changeDirection_1(dir);
                }
                else if (grid[row][col] == 2) { // '\' 이면
                    dir = changeDirection_2(dir);
                }
                // System.out.print(dir + " ");
            }
            else { // 밖이면 그냥 나가자
                cnt++;
                break;
            }

        } while (inRange(row, col));

        // System.out.println();
        // for (int r = 1; r <= n; r++) {
        //     for (int c = 1; c <= n; c++) {
        //         System.out.print(visited[r][c] ? "T " : "F ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        max = Math.max(max, cnt);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                grid[r][c] = kb.nextInt();
            }
        }


        dr.put('U', -1);
        dc.put('U', 0);

        dr.put('D', 1);
        dc.put('D', 0);

        dr.put('L', 0);
        dc.put('L', -1);

        dr.put('R', 0);
        dc.put('R', 1);

        for (int d = 0; d < 4; d++) {
            char dir = chars[d];
            // System.out.println(dir);
            for (int i = 1; i <= n; i++) {
                // 위로 올라가는 것부터
                if (dir == 'U') {
                    int startRow = n + 1;
                    int startCol = i;
                    simulate(startRow, startCol, dir);
                }
                if (dir == 'D') {
                    int startRow = 0;
                    int startCol = i;
                    simulate(startRow, startCol, dir);
                }
                if (dir == 'L') {
                    int startRow = i;
                    int startCol = n + 1;
                    simulate(startRow, startCol, dir);
                }
                if (dir == 'R') {
                    int startRow = i;
                    int startCol = 0;
                    simulate(startRow, startCol, dir);
                }
            }
        }
        System.out.println(max);
    }
}