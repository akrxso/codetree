import java.util.*;

public class Main {

    static final int MAX_N = 10;
    
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[] visited = new boolean[MAX_N];
    static List<Integer> paths = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        getMinPath(0, 0);
        System.out.println(min);
    }

    static void getMinPath(int cnt, int from) {
        // 기저조건
        if (cnt == N) {
            int sum = 0;
            int init = 0;
            for (int i = 0; i < paths.size(); i++) {
                int to = paths.get(i);
                sum += grid[init][to];
                init = to;
            }
            sum += grid[init][0];
            min = Math.min(min, sum);

            // System.out.print("0 -> ");
            // for (int path : paths) {
            //     System.out.print(path + " -> ");
            // }
            // System.out.println();
            return;
        }

        if (cnt == N - 1) {
            if (grid[from][0] != 0) {
                getMinPath(cnt + 1, 0);
            }
            return;
        }

        for (int to = 0; to < N; to++) {
            if (grid[from][to] == 0 || to == 0) continue;
            if (visited[to]) continue;

            visited[to] = true;
            paths.add(to);

            getMinPath(cnt + 1, to);

            paths.remove(paths.size() - 1);
            visited[to]= false;
        }
    }


}