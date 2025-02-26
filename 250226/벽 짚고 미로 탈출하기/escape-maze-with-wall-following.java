import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static int[][] maze = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    
    static int n;
    static int startRow;
    static int startCol;
    static int cnt = 0;

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    static int curDir = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                maze[i][j] = line.charAt(j) == '#' ? 1 : 0;
            }
        }
        
        int curRow = startRow;
        int curCol = startCol;
        visited[curRow][curCol] = true;

        while (true) {
            int nextRow = curRow + dr[curDir];
            int nextCol = curCol + dc[curDir];

            // 경계선 밖이면 끝
            if (nextRow < 0 || n <= nextRow || nextCol < 0 || n <= nextCol) {
                cnt++;
                break;
            }
            if (maze[nextRow][nextCol] == 1) { // 장애물이면
                curDir = (curDir + 1) % 4;
            }
            else { // 장애물이 아니면
                int blockDir = curDir - 1 < 0 ? 3 : curDir - 1;
                int blockRow = nextRow + dr[blockDir];
                int blockCol = nextCol + dc[blockDir];
                // 경계 처리 해야 하나?
                if (maze[blockRow][blockCol] == 1) { // 벽이 있으면 한 칸 그대로 이동
                    if (visited[nextRow][nextCol]) {
                        cnt = -1;
                        break;
                    }
                    curRow = nextRow;
                    curCol = nextCol;
                    visited[curRow][curCol] = true;
                    cnt++;
                }
                else { // 벽이 없다면
                    if (visited[blockRow][blockCol]) {
                        cnt = -1;
                        break;
                    }
                    curRow = blockRow;
                    curCol = blockCol;
                    curDir = blockDir;
                    visited[curRow][curCol] = true;
                    cnt += 2;
                }
            }
        }
        System.out.println(cnt);
    }
}