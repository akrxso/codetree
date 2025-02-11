import java.util.*;

public class Main {

    static final int MAX_N = 10;

    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int max = Integer.MIN_VALUE;
    static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        getMax(0);
        System.out.println(max);
    }

    static void getMax(int currRow) {
        // 기저 조건
        if (currRow == N) {
            int sum = 0;
            for (Pair pair : pairs) {
                sum += grid[pair.row][pair.col];
            }
            max = Math.max(max, sum);
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isAvailable(currRow, c)) {
                pairs.add(new Pair(currRow, c));
                getMax(currRow + 1);
                pairs.remove(pairs.size() - 1);
            }
        }
    }

    static boolean isAvailable(int row, int col) {
        for (Pair pair : pairs) {
            if (pair.row == row || pair.col == col) {
                return false;
            }
        }
        return true;
    }



    static class Pair {
        int row;
        int col;
        Pair (int r, int c) {
            row = r;
            col = c;
        }
    }
}