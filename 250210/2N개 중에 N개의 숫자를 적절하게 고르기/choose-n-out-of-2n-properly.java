import java.util.*;

public class Main {

    static final int MAX_N = 10;

    static int N;
    static int[] num = new int [2 * MAX_N];
    static boolean[] visited = new boolean[2 * MAX_N]; 

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < 2 * N; i++) {
            num[i] = kb.nextInt();
        }
        findMin(0, 0);
        System.out.println(ans);
    }

    static void findMin(int idx, int cnt) {
        if (idx == 2 * N) {
            return;
        }
        if (cnt == N) {
            ans = Math.min(ans, getResult());
            return;
        }

        visited[idx] = true;
        findMin(idx + 1, cnt + 1);
        visited[idx] = false;

        findMin(idx + 1, cnt);
    }

    static int getResult() {
        int diff = 0;

        for (int i = 0; i < 2 * N; i++) {
            diff = (visited[i] ? diff + num[i] : diff - num[i]);
        }
        return Math.abs(diff);
    }
}