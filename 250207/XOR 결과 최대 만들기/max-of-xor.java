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

        findComb(0, 0);

        System.out.println(max);
    }

    static void findComb(int curIdx, int cnt) {
        if (curIdx == N || cnt == M) {
            if (cnt == M) {
                max = Math.max(max, getXor());
            }
            return;
        }

        // 현재 숫자를 넣는다면
        combination.add(numbers.get(curIdx));
        findComb(curIdx + 1, cnt + 1);
        // 현재 숫자를 넣어주었으니 다시 지워줘야 한다.
        combination.remove(combination.size() - 1);

        // 현재 숫자는 안넣고 지나간다
        findComb(curIdx + 1, cnt);
    }

    static int getXor() {
        int result = combination.get(0);

        for (int i = 1; i < combination.size(); i++) {
            result = result ^ combination.get(i);
        }
        return result;
    }
}