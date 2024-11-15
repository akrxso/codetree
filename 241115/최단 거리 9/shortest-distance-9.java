import java.util.*;

public class Main {

    static final int MAX_N = 1000;

    static List<Node>[] graph = new List[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];
    static int[] path = new int[MAX_N + 1];
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

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        } // 세팅

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

            if (dist[minIndex] != minDist) continue;

            for (int j = 0; j < graph[minIndex].size(); j++) {
                Node next = graph[minIndex].get(j);
                int targetIndex = next.index;
                int targetDist = next.dist;

                int newDist = minDist + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    path[targetIndex] = minIndex;

                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        int x = E;
        List<Integer> record = new ArrayList<>();
        record.add(x);
        while (x != S) {
            x = path[x];
            record.add(x);
        }

        System.out.println(dist[E]);
        for (int i = record.size() - 1; i >= 0; i--) {
            System.out.print(record.get(i) +  " ");
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
