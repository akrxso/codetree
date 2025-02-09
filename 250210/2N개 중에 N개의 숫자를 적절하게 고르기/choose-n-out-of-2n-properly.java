import java.util.*;

public class Main {

    static int N;
    static int LIMIT;

    static List<Integer> arr = new ArrayList<>();
    static List<Integer> indexComb = new ArrayList<>();
    static int sum = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        LIMIT = N * 2;

        for (int i = 0; i < LIMIT; i++) {
            arr.add(kb.nextInt());
        }
        for (int i = 0; i < LIMIT; i++) {
            sum += arr.get(i);
        }
        getCombination(0, 0);
        System.out.println(min);
    }

    static void getCombination(int curIdx, int lastNumber) {
        // 기저조건
        if (curIdx == N) {
            int result = getResult();
            int other = sum - getResult();
            min = Math.min(min, Math.abs(result - other));
            return;
        }

        for (int i = lastNumber; i < LIMIT; i++) {
            indexComb.add(i);
            getCombination(curIdx + 1, i + 1);
            indexComb.remove(indexComb.size() - 1);
        }
    }

    static int getResult() {
        int valueSum = 0;

        for (int i = 0; i < N; i++) {
            int idx = indexComb.get(i);
            valueSum += arr.get(idx);
        }
        return valueSum;
    }

}