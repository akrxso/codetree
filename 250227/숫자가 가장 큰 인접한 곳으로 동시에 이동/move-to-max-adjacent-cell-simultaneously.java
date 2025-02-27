import java.util.Scanner;

public class Main {

    static final int MAX_N = 20;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] count = new int[MAX_N][MAX_N];
    static int[][] nextCount = new int[MAX_N][MAX_N];

    static int n;
    static int m;
    static int t;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        t = kb.nextInt();

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = kb.nextInt() - 1;
            int c = kb.nextInt() - 1;
            count[r][c] = 1;
        }

        for (int i = 0; i < t; i++) { // 시간이 지나는 동안
            // 다음 구슬 위치 앞서서 초기화
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    nextCount[r][c] = 0;
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (count[r][c] == 1) { // 폭탄이 있는 위치면
                        int max = Integer.MIN_VALUE;
                        int maxIdx = -1;
                        for (int d = 0; d < 4; d++) {
                            int nextRow = r + dr[d];
                            int nextCol = c + dc[d];

                            if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] > max) {
                                // 범위 안이고, Max보다 크다면
                                max = grid[nextRow][nextCol];
                                maxIdx = d;
                            }
                        }
                        int finalRow = r + dr[maxIdx];
                        int finalCol = c + dc[maxIdx];
                        nextCount[finalRow][finalCol]++;
                    }
                }
            }
//            print(nextCount);

            // 복사하기
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    count[r][c] = nextCount[r][c];
                }
            }
            // 구슬 겹치면 없애기
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (count[r][c] > 1) {
                        count[r][c] = 0;
                    }
                }
            }
        }

        int cnt = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (count[r][c] == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < n;
    }
    static void print(int[][] arr) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}