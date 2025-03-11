import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MAX = 1000;
    static int N;

    static int[] dp = new int[MAX + 1];
    static List<int[]>[] lines = new List[MAX + 1];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        for (int i = 0; i <= MAX; i++) {
            lines[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            lines[end].add(new int[]{start, end});
            lines[end].sort((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            });
        }

        for (int i = 1; i <= MAX; i++) {
            List<int[]> list = lines[i];
            // 비어있지 않다면
            if (!list.isEmpty()) {
                for (int[] line : list) {
                    int start = line[0];
                    int end = line[1];
                    dp[i] = Math.max(dp[i], dp[start - 1] + 1);
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

//        for (int i = 0; i <= 10; i++) {
//            System.out.print(dp[i] + " ");
//        }

        System.out.println(dp[MAX]);
    }
}
