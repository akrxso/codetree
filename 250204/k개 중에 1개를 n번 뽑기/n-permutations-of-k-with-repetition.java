import java.util.*;

public class Main {

    static int K;
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        K = kb.nextInt();
        N = kb.nextInt();

        arr = new int[N];
        findPermutations(0);
    }

    public static void printPermutation() {
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findPermutations(int currIdx) {
        // 기저 조건
        if (currIdx == N) {
            printPermutation();
            return;
        }

        for (int i = 1; i <= K; i++) {
            arr[currIdx] = i;
            findPermutations(currIdx + 1);
        }
    }
}