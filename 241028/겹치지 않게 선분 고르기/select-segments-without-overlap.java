import java.util.*;

public class Main {
    static final int MAX_N = 15;
    static Pair[] pairs = new Pair[MAX_N];

    static int N;
    static int ans = 0;

    static List<Pair> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            pairs[i] = new Pair(start, end);
        }

        findMaxLine(0);
        System.out.println(ans);
    }

    static void findMaxLine(int index) {
        if (index == N) {
            if (checkOverlap()) {
                ans = Math.max(ans, selected.size());
            }
            return;
        }
        selected.add(pairs[index]);
        findMaxLine(index + 1);
        selected.remove(selected.size() - 1);

        findMaxLine(index + 1);
    }

    static boolean isOverlapped(Pair a, Pair b) {
        int a_start = a.start;
        int a_end = a.end;

        int b_start = b.start;
        int b_end = b.end;

        // 선분의 겹치는 여부는, 한 점이 다른 선분에 포함되는 경우
        return a_start <= b_start && b_start <= a_end || a_start <= b_end && b_end <= a_end ||
                b_start <= a_start && a_start <= b_end || b_start <= a_end && a_end <= b_end;
    }

    static boolean checkOverlap() {
        for (int i = 0; i < selected.size(); i++) {
            for (int j = i + 1; j < selected.size(); j++) {
                if (isOverlapped(selected.get(i), selected.get(j))) return false;
            }
        }
        return true;
    }

    static class Pair {
        int start;
        int end;
        public Pair(int s, int e) {
            start = s;
            end = e;
        }
    }
}