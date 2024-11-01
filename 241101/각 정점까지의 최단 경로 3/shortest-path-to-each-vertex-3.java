import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX_N = 100;
    static final int INF = (int) 1e9;

    static int N;
    static int M;

    static List<int[]>[] adjList = new List[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());

            adjList[start].add(new int[]{end, weight});
        }

        // 초기 거리 배열 설정
        Arrays.fill(dist, INF);
        dist[1] = 0;

        dijkstra(1);
        for (int i = 2; i <= N; i++) {
            // 만약 도달이 불가능하다면 -1 출력
            if (dist[i] == INF) {
                System.out.println(-1);
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }

    static void dijkstra(int start) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0}); // 시작 정점에서 출발

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int now = current[0];
            int weight = current[1];

            // 현재 거리보다 긴 경로는 무시한다
            if (weight > dist[now]) continue;

            // 현재 노드와 인접한 노드들 탐색
            for (int[] edge : adjList[now]) {
                int next = edge[0];
                int nextWeight = edge[1];

                // 최단 거리 갱신
                if (dist[next] > dist[now] + nextWeight) {
                    dist[next] = dist[now] + nextWeight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
    }
}