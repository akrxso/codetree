import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int max;

    static List<Integer> bombRows = new ArrayList<>();
    static List<Integer> bombCols = new ArrayList<>();
    static List<Integer> bombTypes = new ArrayList<>();
    static int bombCount;

    static int[][] dr = {
        {0},
        {-2, -1, 1, 2},
        {-1, 0, 1, 0},
        {-1, -1, 1, 1}
    };
    static int[][] dc = {
        {0},
        {0, 0, 0, 0},
        {0, 1, 0, -1},
        {-1, 1, 1, -1}
    };


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = kb.nextInt();
            }
        }

        // 폭탄의 위치 찾고 저장
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1) {
                    bombRows.add(r);
                    bombCols.add(c);
                }
            }
        }
        bombCount = bombRows.size();
        permutation(0);

        System.out.println(max);
    }

    public static void permutation(int currIdx) {
        // 기저조건
        if (currIdx == bombCount) {
            int curBombCnt = countBomb();
            max = Math.max(max, curBombCnt);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            bombTypes.add(i);
            permutation(currIdx + 1);
            bombTypes.remove(bombTypes.size() - 1);
        }
    }

    public static int countBomb() {
        int[][] grid = new int[N][N];
        for (int i = 0; i < bombCount; i++) {
            int bombType = bombTypes.get(i);

            int[] rowSeq = dr[bombType];
            int[] colSeq = dc[bombType];

            int curRow = bombRows.get(i);
            int curCol = bombCols.get(i);

            grid[curRow][curCol] = 1;

            for (int d = 0; d < 4; d++) {
                int nextRow = curRow + rowSeq[d];
                int nextCol = curCol + colSeq[d];

                // 경계처리
                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
                grid[nextRow][nextCol] = 1;
            }
        }

        int cnt = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}