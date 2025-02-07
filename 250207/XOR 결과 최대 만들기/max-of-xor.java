import java.util.*;

public class Main {

    static int N;
    static int M;

    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> combination = new ArrayList<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 0; i < N; i++) {
            numbers.add(kb.nextInt());
        }

        findCombination(0, 0);
        System.out.println(max);
    }

    static void findCombination(int curCnt, int lastIdx) {
        if (curCnt == M) {
            max = Math.max(max, getXor());
            return;
        }

        for (int i = lastIdx; i < N; i++) {
            combination.add(numbers.get(i));
            findCombination(curCnt + 1, i + 1);
            combination.remove(combination.size() - 1);
        }
    }

    static int getXor() {
        int result = combination.get(0);

        for (int i = 1; i < combination.size(); i++) {
            result = result ^ combination.get(i);
        }
        return result;
    }
}