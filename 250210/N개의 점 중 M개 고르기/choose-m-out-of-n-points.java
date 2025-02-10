import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;

    static List<Pair> pairs = new ArrayList<>();
    static List<Pair> combination = new ArrayList<>();

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 0; i < N; i++) {
            pairs.add(new Pair(kb.nextInt(), kb.nextInt()));
        }
        getComb(0, 0);
        System.out.println(min);
    }

    public static void getComb(int idx, int cnt) {
        if (cnt == M) {
            min = Math.min(min, calc());
            return;
        }
        if (idx == N) {
            return;
        }

        Pair currPair = pairs.get(idx);
        combination.add(currPair);
        getComb(idx + 1, cnt + 1);
        combination.remove(combination.size() - 1);

        getComb(idx + 1, cnt);
    }

    static int calc() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            Pair currPair = combination.get(i);
            for (int j = i + 1; j < M; j++) {
                Pair otherPair = combination.get(j);
                int x = Math.abs(currPair.x - otherPair.x);
                int y = Math.abs(currPair.y - otherPair.y);
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
