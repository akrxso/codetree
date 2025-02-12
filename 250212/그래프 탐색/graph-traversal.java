import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] adjMatrix; 
    static boolean[] visited;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        adjMatrix = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            adjMatrix[start][end] = adjMatrix[end][start] = 1;
        }
        visited[1] = true;
        dfs(1);
        
        int cnt = 0;
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) cnt++;
        }

        System.out.println(cnt);
    }

    static void dfs(int vertex) {
        for (int next = 1; next <= N; next++) {
            if (adjMatrix[vertex][next] == 1 & !visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}