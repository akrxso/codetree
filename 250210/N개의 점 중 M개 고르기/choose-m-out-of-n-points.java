import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Pair> pairs = new ArrayList<>();
    static List<Pair> combination = new ArrayList<>();

    static List<Pair> results = new ArrayList<>();

    static int ans = Integer.MAX_VALUE;
    static int max;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 0; i < N; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            pairs.add(new Pair(x, y));
        }

        getMin(0, 0);
        System.out.println(ans);
    }

    // combination 배열의 curIdx
    static void getMin(int curIdx, int lastIndex) {
        if (curIdx == M) {
            // System.out.println("combination: " + combination + " >>>");
            max = Integer.MIN_VALUE;
            calc(0, 0);
            ans = Math.min(ans, max);
            return;
        }

        for (int i = lastIndex; i < N; i++) {
            Pair curPair = pairs.get(i);
            combination.add(curPair);
            getMin(curIdx + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    static void calc(int curIdx, int cnt) {
        if (cnt == 2) {
            // System.out.println(results);
            Pair one = results.get(0);
            Pair other = results.get(1);
            int x = Math.abs(one.x - other.x);
            int y = Math.abs(one.y - other.y);
            max = Math.max(max, (x * x) + (y * y));
            return;
        }

        if (curIdx == M) {
            return;
        }

        Pair curPair = combination.get(curIdx);
        results.add(curPair);
        calc(curIdx + 1, cnt + 1);
        results.remove(results.size() - 1);

        calc(curIdx + 1, cnt);
    }



    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x: " + x + " y: " + y;
        }
    }
}