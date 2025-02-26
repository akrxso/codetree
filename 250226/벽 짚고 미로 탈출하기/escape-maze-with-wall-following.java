import java.util.Scanner;

public class Main {

    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n;

    static int currRow;
    static int currCol;
    static int currDir;

    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[][][] visited = new boolean[DIR_NUM][MAX_N][MAX_N];
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int time;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        currRow = kb.nextInt() - 1;
        currCol = kb.nextInt() - 1;
        // 처음에 우측 방향
        currDir = 0;

        for (int r = 0; r < n; r++) {
            String str = kb.next();
            for (int c = 0; c < n; c++) {
                grid[r][c] = str.charAt(c) == '#' ? 1 : 0;
            }
        }

        do {
            simulate();
        } while (inRange(currRow, currCol));

        System.out.println(time);
    }

    static void simulate() {
        if (visited[currDir][currRow][currCol]) {
            System.out.println(-1);
            System.exit(0);
        }

        // 현재 상황이 다시 반복되는지를 나중에 확인하기 위해
        // 현재 상황에 해당하는 곳에 visited 값을 true로 설정한다.
        visited[currDir][currRow][currCol] = true;

        int nextRow = currRow + dr[currDir];
        int nextCol = currCol + dc[currDir];

        // 바라보는 방향이 벽이라면
        if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] == 1) {
            currDir = (currDir - 1 + 4) % 4;
        }
        // 바라보는 방향이 벽이 아니라면
        // 만약 바로 앞이 격자 밖이라면 탈출
        else if (!inRange(nextRow, nextCol)) {
            currRow = nextRow;
            currCol = nextCol;
            time++;
        }
        // 바로 앞이 격자 안이라면
        else {
            int blockRow = nextRow + dr[(currDir + 1) % 4];
            int blockCol = nextCol + dc[(currDir + 1) % 4];

            // 오른쪽에 벽이 있다면
            if (inRange(blockRow, blockCol) && grid[blockRow][blockCol] == 1) {
                currRow = nextRow;
                currCol = nextCol;
                time++;
            }
            // 벽이 없다면
            else {
                currRow = blockRow;
                currCol = blockCol;
                currDir = (currDir + 1) % 4;
                time += 2;
            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
