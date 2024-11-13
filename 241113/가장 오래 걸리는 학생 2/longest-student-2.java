import java.util.*;

public class Main {

    static final int MAX_N = 100_000;

    static List<Node>[] graph = new List[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];

    static Queue<Element> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

    static int N;
    static int M;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            graph[end].add(new Node(start, dist));
        }// 모두 학교에 도착해야하기 때문에 반대로 학교에서 시작하기 위해, 방향 그래프를 반대로 설정

        Arrays.fill(dist, 1, N, (int) 1e9);
        dist[N] = 0;

        pq.add(new Element(N, 0));

        while(!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if (dist[minIndex] != minDist) continue;

            for (int j = 0; j < graph[minIndex].size(); j++) {
                Node target = graph[minIndex].get(j);
                int targetIndex = target.index;
                int targetDist = target.dist;

                int newDist = minDist + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dist[i]);
        }
        System.out.println(max);  
    }

    static class Element {
        int index;
        int dist;
        Element(int i, int d) {
            index = i;
            dist = d;
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
}