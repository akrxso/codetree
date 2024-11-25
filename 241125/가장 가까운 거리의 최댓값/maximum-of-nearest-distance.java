import java.util.*;

public class Main {
    static final int MAX_N = 100_000;

    static List<Node>[] graph = new List[MAX_N + 1];

    static int[] dist = new int[MAX_N + 1];
    static int[] abcDist = new int[MAX_N + 1];

    static int N;
    static int M;
    static int a;
    static int b;
    static int c;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        a = kb.nextInt();
        b = kb.nextInt();
        c = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int j = 1; j <= M; j++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }

        // a, b, c로부터 각 정점까지의 최단 거리 중 최솟값을 저장할
        // minDist 배열을 전부 INT_MAX로 초기화한다.
        for (int i = 1; i <= N; i++) {
            abcDist[i] = Integer.MAX_VALUE;
        }

        getPath(a);
        getPath(b);
        getPath(c);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, abcDist[i]);
        }
        
        System.out.println(ans);
    }

    static void getPath(int startIndex) {
        Arrays.fill(dist, 1, N + 1, (int) 1e9);
        Queue<Element> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        dist[startIndex] = 0;
        pq.add(new Element(startIndex, 0));

        while (!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if (dist[minIndex] != minDist) continue;

            for (int i = 0; i < graph[minIndex].size(); i++) {
                Node target = graph[minIndex].get(i);
                int targetIndex = target.index;
                int targetDist = target.dist;

                int newDist = minDist + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            abcDist[i] = Math.min(abcDist[i], dist[i]);
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