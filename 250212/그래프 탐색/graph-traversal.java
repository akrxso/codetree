import java.util.*;

public class Main {
    
    static final int MAX_N = 1000;

    static int N;
    static int M;
    static int cnt;

    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        
        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            graph[start][end] = graph[end][start] = 1;
        }
        
        visited[1] = true;
        dfs(1);

        System.out.println(cnt);
    }
    
    static void dfs(int vertex) {
        for (int next = 1; next <= N; next++) {
            if (graph[vertex][next] == 1 && !visited[next]) {
                visited[next] = true;
                dfs(next);
                cnt++;
            }
        }
    }
}
