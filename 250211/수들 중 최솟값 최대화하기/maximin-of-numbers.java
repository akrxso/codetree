import java.util.*;

public class Main {

    static final int MAX_N = 10;
    
    static int N;
    static int[][] grid = new int[MAX_N][MAX_N];
    static List<Pair> pairs = new ArrayList<>();

    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        
        for (int r = 0; r < N; r++)
            for (int c = 0; c < N; c++)
                grid[r][c] = kb.nextInt();
    
        getMin(0);
        System.out.println(max);
    }
    
    static void getMin(int row) {
        // 기저 조건
        if (row == N) {
            int min = Integer.MAX_VALUE;
            for (Pair pair : pairs) {
                min = Math.min(min, grid[pair.row][pair.col]);
            }
            max = Math.max(max, min);
            return;
        }
        
        for (int c = 0; c < N; c++) {
            if (isAvailable(row, c)) {
                pairs.add(new Pair(row, c));
                getMin(row + 1);
                pairs.remove(pairs.size() - 1);
            }
        }
    }
    
    static boolean isAvailable(int r, int c) {
        for (Pair pair : pairs) {
            if (pair.row == r || pair.col == c) {
                return false;
            }
        }
        return true;
    }
    
    static class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }
}
