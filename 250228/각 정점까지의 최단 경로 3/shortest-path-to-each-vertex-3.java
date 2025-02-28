import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static List<Pair>[] adjList = new List[MAX_N + 1];
    static int[] result = new int[MAX_N + 1];

    static int N;
    static int M;
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<Pair>();
        }

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int weight = kb.nextInt();

            adjList[start].add(new Pair(end, weight));
        }

        Arrays.fill(result, Integer.MAX_VALUE);
        dijk(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    static void dijk(int start) {
        result[start] = 0;
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            List<Pair> list = adjList[curNode.idx];
            for (int i = 0; i < list.size(); i++) {
                Pair next = list.get(i);
                if (result[next.to] > result[curNode.idx] + next.weight) {
                    result[next.to] = result[curNode.idx] + next.weight;
                    pq.add(new Node(next.to, result[next.to]));
                }
            }
        }
    }

    static class Node {
        int idx;
        int weight;
        Node(int i, int w) {
            idx = i;
            weight = w;
        }
    }

    static class Pair {
        int to;
        int weight;

        Pair (int t, int w) {
            to = t;
            weight = w;
        }
    }
}