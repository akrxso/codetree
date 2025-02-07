import java.util.*;

public class Main {

    static int M;
    static int N;

    static int[] result;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        result = new int[M];
        comb(0, 1);
    }

    static void comb(int curIdx, int cnt) {
        if (curIdx == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = cnt; i <= N; i++) {
            result[curIdx] = i;
            comb(curIdx + 1, i + 1);
        }
    }
}