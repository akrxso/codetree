import java.util.*;

public class Main {

    static final int MAX_N = 1_000;
    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];

    static int[] dist = new int[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];

    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            // 무방향 그래프라 간선을 뒤집을 필요가 없다.
            graph[start][end] = dist;
            graph[end][start] = dist;
        }

        int S = kb.nextInt();
        int E = kb.nextInt();
        // 사전순으로 하려면 간선을 뒤집고 도착점에서 시작점으로 다익스트라를 진행해야 한다.
        
        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[E] = 0;

        // dist에 담길 노드의 개수만큼 For문
        for (int i = 1; i <= N; i++) {
            int minIndex = -1;
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            // 최소값을 가진 정점에 방문 표시
            visited[minIndex] = true;
            for (int j = 1; j <= N; j++) {
                if (graph[minIndex][j] == 0) continue; // 이어져 있지 않다면 생략

                if (dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                }
            }
        }

        System.out.println(dist[S]);

        int x = S;
        List<Integer> record = new ArrayList<>();
        record.add(x);
        while (x != E) {
            for (int i = 1; i <= N; i++) {
                // 간선이 존재하지 않는 경우에는 생략한다. 
                if (graph[i][x] == 0) continue;

                if (dist[i] + graph[i][x] == dist[x]) {
                    x = i;
                    break;
                }
            }
            record.add(x);
        }

        for (int e : record) {
            System.out.print(e + " ");
        }
    }
}