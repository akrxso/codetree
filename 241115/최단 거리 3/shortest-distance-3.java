import java.util.*;

public class Main {
    
    static final int MAX_N = 1_000;
    
    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];

    static int N;
    static int M;
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            // 양방향 그래프
            graph[start][end] = dist;
            graph[end][start] = dist;
        }
        
        int S = kb.nextInt();
        int E = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;

        for (int i = 1; i <= N; i++) {
            int minIndex = -1;
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            // 방문처리
            visited[minIndex] = true;

            // 갈 수 있는 곳 확인
            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] == 0) continue;

                if (dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }

        System.out.println(dist[E]);
    }
}