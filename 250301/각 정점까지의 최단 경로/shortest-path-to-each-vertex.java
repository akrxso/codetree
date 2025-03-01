import java.util.*;

public class Main {
    static final int MAX_N = 20_000;
    

    static int N;
    static int M;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int M = kb.nextInt();
        int K = kb.nextInt();

        dist = new int[N + 1];
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, (int)1e9);

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int weight = kb.nextInt();

            graph[start].add(new Node(end, weight));
            graph[end].add(new Node(start, weight));
        }

        dijk(K);
        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i]);
        }
    }

    static void dijk(int start) {
        dist[start] = 0;
        Queue<Element> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Element(start, 0));

        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            int now = cur.idx;
            int weight = cur.weight;

            if (weight > dist[now]) continue;
            
            List<Node> list = graph[now];
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                int next = node.to;
                int nextWeight = node.weight;

                if (dist[next] > dist[now] + nextWeight) {
                    dist[next] = dist[now] + nextWeight;
                    pq.offer(new Element(next, dist[next]));
                }
            }
        }
    }

    static class Element {
        int idx;
        int weight;
        Element(int i, int w) {
            this.idx = i;
            this.weight = w;
        }
    }

    static class Node {
        int to;
        int weight;
        Node (int t, int w) {
            to = t;
            weight = w;
        }
    }
}