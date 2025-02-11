import java.util.*;

public class Main {

    static final int MAX_N = 10;
    
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[] visited = new boolean[MAX_N];
    static List<Integer> colIdxs = new ArrayList<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                grid[r][c] = kb.nextInt();

        getMin(0);
        System.out.println(max);
    }

    static void getMin(int row) {
        // 기저 조건
        if (row == N) {
            int min = grid[0][colIdxs.get(0)];
            for (int i = 1; i < colIdxs.size(); i++) {
                min = Math.min(min, grid[i][colIdxs.get(i)]);
            }
            max = Math.max(max, min);
        }

        for (int c = 0; c < N; c++) {
            if (visited[c]) continue;

            visited[c] = true;
            colIdxs.add(c);
            
            getMin(row + 1);

            visited[c] = false;
            colIdxs.remove(colIdxs.size() - 1);

        }
    }
}