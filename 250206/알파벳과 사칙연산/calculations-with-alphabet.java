import java.util.*;

public class Main {

    static final int MAX_SIZE = 'f' - 'a' + 1;

    static int[] arr;
    
    static List<Character> sequence = new ArrayList<>();
    static List<Character> symbols = new ArrayList<>();
    static Map<Character, Integer> map = new HashMap<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String line = kb.nextLine();

        for (int i = 0; i < line.length(); i++) {
            if (i % 2 == 0) {
                sequence.add(line.charAt(i));
            }
            else {
                symbols.add(line.charAt(i));
            }
        }
        // System.out.println(sequence);
        // System.out.println(symbols);

        arr = new int[MAX_SIZE];
        permutation(0);

        System.out.println(max);

    }

    static void permutation(int curIdx) {
        // 기저조건
        if (curIdx == MAX_SIZE) {
            int result = getResult();
            max = Math.max(max, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            arr[curIdx] = i;
            permutation(curIdx + 1);
        }
    }

    static int getResult() {
        int sum = arr[sequence.get(0) - 'a'];

        for (int i = 1; i < sequence.size(); i++) {
            int number = arr[sequence.get(i) - 'a'];
            char symbol = symbols.get(i - 1);
            if (symbol == '+') {
                sum += number;
            }
            if (symbol == '-') {
                sum -= number;
            }
            if (symbol == '*') {
                sum *= number;
            }
        }
        return sum;
    }
}