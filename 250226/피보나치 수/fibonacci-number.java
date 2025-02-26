import java.util.*;

public class Main {
    static final int MAX_N = 45;

    static int N;
    static int[] memo = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Arrays.fill(memo, -1);        
        fibbo(N);
        System.out.println(memo[N]);
    }

    static int fibbo(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n <= 2) {
            return memo[n] = 1;
        }
        return memo[n] = fibbo(n - 1) + fibbo(n - 2);
    }
}