import java.util.*;

public class Main {

    static int K;
    static int N;

    static int[] answer;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        K = kb.nextInt();
        N = kb.nextInt();

        answer = new int[N];

        getResult(0);
    }

    static void getResult(int curIdx) {
        // 기저조건
        if (curIdx == N) {
            print();
            return;
        }

        for (int i = 1; i <= K; i++) {
            if (curIdx == 0 || curIdx == 1) { // 0번, 1번은 검증 안해도 됨
                answer[curIdx] = i;
                getResult(curIdx + 1);
            }
            else {
                if (i != answer[curIdx - 1] || i != answer[curIdx - 2]) {
                    answer[curIdx] = i;
                    getResult(curIdx + 1);
                }
            }
        }
    }

    static void print() {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}