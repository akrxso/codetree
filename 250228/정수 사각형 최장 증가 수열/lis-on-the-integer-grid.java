import java.util.*;

public class Main {
    static final int MAX_N = 500;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] dp = new int[MAX_N][MAX_N];

    static int N;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans = 0;

    static boolean inRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }
    static void simulate(int row, int col) {
        int max = 0;
        for (int d = 0; d < 4; d++) {
            int nextRow = row + dr[d];
            int nextCol = col + dc[d];

            // 경계 안에 있고, 해당 값이 grid보다 작을 때
            if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] < grid[row][col]) {
                max = Math.max(max, dp[nextRow][nextCol]);
            }
        }
        dp[row][col] = max + 1;
        ans = Math.max(ans, dp[row][col]);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                set.add(grid[r][c]);
            }
        }
        List<Integer> numbers = new ArrayList<>(set);
        Collections.sort(numbers);

        // 초기 세팅
        int minNumber = numbers.get(0);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (minNumber == grid[r][c]) { // 가장 낮은수랑 같다면
                    dp[r][c] = 1;
                }
            }
        }

        for (int i = 1; i < numbers.size(); i++) { // 그 다음 숫자부터
            int number = numbers.get(i);
//            System.out.println("number : " + number);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == number) {
                        simulate(r, c);
                    }
                }
            }
//            print();
        }
        System.out.println(ans);

    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(dp[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
