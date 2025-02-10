import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<Pair> pairs = new ArrayList<>();
    static List<Pair> combination = new ArrayList<>();

    static int ans = Integer.MAX_VALUE;

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

    static void getMin(int curIdx, int lastIndex) {
        if (curIdx == 2) {
            // System.out.println(combination);
            ans = Math.min(ans, calc());
            return;
        }

        for (int i = lastIndex; i < N; i++) {
            Pair curPair = pairs.get(i);
            combination.add(curPair);
            getMin(curIdx + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    static int calc() {
        Pair one = combination.get(0);
        Pair other = combination.get(1);

        int x = Math.abs(one.x - other.x);
        int y = Math.abs(one.y - other.y);

        return (x * x) + (y * y);
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