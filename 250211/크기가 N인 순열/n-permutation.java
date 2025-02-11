import java.util.*;

public class Main {

    static final int MAX_N = 8;
    static final boolean[] visited = new boolean[MAX_N + 1];

    static int N;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        choose(0);
    }

    public static void choose(int currIdx) {
        // 기저조건
        if (currIdx == N) {
            print();
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 이미 사용했으면 건너 뛴다
            if (visited[i]) continue;

            visited[i] = true;
            answer.add(i);

            choose(currIdx + 1);

            answer.remove(answer.size() - 1);
            visited[i] = false;
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}