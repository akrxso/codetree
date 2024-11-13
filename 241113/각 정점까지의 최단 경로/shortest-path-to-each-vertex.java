import java.util.*;

public class Main {

    static final int MAX_N = 20_000;

    static List<Node>[] graph = new List[MAX_N];
    static int[] dist = new int[MAX_N];
    static Queue<Element> pq = new PriorityQueue<Element>((a, b) -> a.dist - b.dist);

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        K = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[K] = 0;

        pq.add(new Element(K, 0));
        
        while(!pq.isEmpty()) {
            int minIdx = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            if (dist[minIdx] != minDist) continue;

            for (int j = 0; j < graph[minIdx].size(); j++) {
                Node other = graph[minIdx].get(j);
                int targetIdx = other.index;
                int targetDist = other.dist;

                int newDist = minDist + targetDist;
                if (dist[targetIdx] > newDist) {
                    dist[targetIdx] = newDist;
                    pq.add(new Element(targetIdx, newDist));
                }

            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i] == (int)1e9 ? -1 : dist[i]);
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

    static class Node {
        int index;
        int dist;
        Node(int i, int d) {
            index = i;
            dist = d;
        }
    }
}