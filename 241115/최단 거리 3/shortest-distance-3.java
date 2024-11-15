import java.util.*;

public class Main {
    
    static final int MAX_N = 1_000;
    
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
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            // 양방향 그래프, 중복된 간선이 여러번 주어질 수 있어서 List로 관리
            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }
        
        int S = kb.nextInt();
        int E = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            dist[i] = (int) 1e9;
        }
        dist[S] = 0;
        
        pq.add(new Element(S, 0));
        while (!pq.isEmpty()) {
            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll();

            // 최소값이 아니면 굳이 볼 필요 없다. 이미 살펴본 것은 제거
            if (dist[minIndex] != minDist) continue;

            for (int j = 0; j < graph[minIndex].size(); j++) {
                Node next = graph[minIndex].get(j);
                int targetIndex = next.index;
                int targetDist = next.dist;

                int newDist = dist[minIndex] + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        System.out.println(dist[E]);
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