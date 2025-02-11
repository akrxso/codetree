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

    static void choose(int currIdx) {
        if (currIdx == N) {
            printAnswer();
            return;
        }

        for (int i = N; i >= 1; i--) {
            if (visited[i]) continue;

            visited[i] = true;
            answer.add(i);

            choose(currIdx + 1);

            answer.remove(answer.size() - 1);
            visited[i] = false;
        }
    }
    static void printAnswer() {
        for (int i = 0; i < N; i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }
}