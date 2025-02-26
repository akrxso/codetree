import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 1000;
    static final int UNUSED = -1;

    static int n;
    static int[] memo = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();

        Arrays.fill(memo, 0, n + 1, UNUSED);

        memo[0] = 1;
        dp(n);
        System.out.println(memo[n]);
    }

    static int dp(int n) {
        if (n < 0) {
            return 0;
        }
        if (memo[n] != UNUSED) {
            return memo[n];
        }

        return memo[n] = dp(n - 2) + dp(n - 3);
    }
}
