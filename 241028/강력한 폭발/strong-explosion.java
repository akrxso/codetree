import java.util.*;

public class Main {
    static int N;
    static int[][] grid;

    static List<int[]> locations = new ArrayList<>();
    static int bombCnt;
    static List<Integer> bombTypes = new ArrayList<>();
    static int max;

    static int[][] typeOne = {
            {-2, 0}, {-1, 0}, {1, 0}, {2, 0}
    };
    static int[][] typeTwo = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int[][] typeThree = {
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
    };

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        grid = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    locations.add(new int[]{r, c});
                }
            }
        }
        bombCnt = locations.size();

        selectBombType(0);
        System.out.println(max);
    }

    public static void selectBombType(int curIdx) {
        if (curIdx == bombCnt) {
            int bombBlock = bomb();
            if (bombBlock > max) max = bombBlock;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            bombTypes.add(i);
            selectBombType(curIdx + 1);
            bombTypes.remove(bombTypes.size() - 1);
        }
    }

    public static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static int bomb() {
        boolean[][] temp = new boolean[N][N];
        for (int i = 0; i < bombCnt; i++) {
            int type = bombTypes.get(i);
            int[] location = locations.get(i);
            temp[location[0]][location[1]] = true;

            if (type == 1) {
                for (int d = 0; d < 4; d++) {
                    int nextRow = location[0] + typeOne[d][0];
                    int nextCol = location[1] + typeOne[d][1];

                    if (inRange(nextRow, nextCol)) temp[nextRow][nextCol] = true;
                }
            }
            else if (type == 2) {
                for (int d = 0; d < 4; d++) {
                    int nextRow = location[0] + typeTwo[d][0];
                    int nextCol = location[1] + typeTwo[d][1];

                    if (inRange(nextRow, nextCol)) temp[nextRow][nextCol] = true;
                }
            }
            else {
                for (int d = 0; d < 4; d++) {
                    int nextRow = location[0] + typeThree[d][0];
                    int nextCol = location[1] + typeThree[d][1];

                    if (inRange(nextRow, nextCol)) temp[nextRow][nextCol] = true;
                }
            }
        }
        int bombBlock = 0;
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                if (temp[r][c]) bombBlock++;
        return bombBlock;
    }
}