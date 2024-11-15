
import java.util.*;

public class Main {

    static final int MAX_N = 1000;

    static int[][] graph = new int[MAX_N + 1][MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] path = new int[MAX_N + 1];

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

            graph[start][end] = dist;
            graph[end][start] = dist;
        } // 세팅

        int S = kb.nextInt();
        int E = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;

        // O(|V|^2) 다익스트라 코드
        for (int i = 1; i <= N; i++) {

            // V개의 정점 중
            // 아직 방문하지 않은 정점에서 dist 값이 가장 작은 정점을 찾아준다.
            int minIndex = -1;
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue; // 이미 방문했다면 굳이 뽑을 필요가 없기 때문에

                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            // 최소값에 해당하는 정점에 방문 처리
            visited[minIndex] = true;

            // 최소값에 해당하는 정점에 연결된 간선들을 보며
            // 시작점으로부터 최단거리 값을 갱신한다.
            for (int j = 1; j <= N; j++) {
                // 간선이 존재하지 않으면 넘어간다.
                if (graph[minIndex][j] == 0) continue;

                if (dist[j] > dist[minIndex] + graph[minIndex][j]) {
                    dist[j] = dist[minIndex] + graph[minIndex][j];
                    // path 값을 갱신한다.
                    path[j] = minIndex;
                }
            }
        }

        // 정점 S에서 정점 E로 가기 위한 최단거리를 출력한다.
        System.out.println(dist[E]);

        // 도착지 E부터 시작하여 시작점 S가 나오기 전까지
        // path를 따라 움직인다.
        int x = E;
        List<Integer> record = new ArrayList<>();
        record.add(x);
        while (x != S) {
            x = path[x];
            record.add(x);
        }

        // 거쳐간 순서를 거꾸로 출력한다.
        for (int i = record.size() - 1; i >= 0; i--) {
            System.out.print(record.get(i) + " ");
        }

    }

    static class Node {
        int index;
        int dist;
        Node(int i, int d) {
            index = i;
            dist = d;
        }
    }
    static class Element {
        int index;
        int dist;
        Element(int i, int d) {
            index = i;
            dist = d;
        }
    }
}
