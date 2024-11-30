import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 30;
    static char[][] grid = new char[MAX_N][MAX_N];

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int N;
    static long A;
    static long B;

    static long answer = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        A = kb.nextLong();
        B = kb.nextLong();

        for (int r = 0; r < N; r++) {
            String line = kb.next();
            for (int c = 0; c < N; c++) {
                grid[r][c] = line.charAt(c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                dijkstra(r, c);
            }
        }
        System.out.println(answer);
    }

    private static void dijkstra(int startRow, int startCol) {
        long max = 0;
        long[][] record = new long[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                record[r][c] = (long) 1e9;
            }
        }
        record[startRow][startCol] = 0;
        visited[startRow][startCol] = true;

        Queue<Element> pq = new PriorityQueue<>((a, b) -> (int)(a.dist - b.dist));
        pq.add(new Element(startRow, startCol, 0));

        while (!pq.isEmpty()) {
            int minRow = pq.peek().row;
            int minCol = pq.peek().col;
            long minDist = pq.peek().dist;
            pq.poll();

            if (record[minRow][minCol] != minDist) continue;

            for (int d = 0; d < 4; d++) {
                int nextRow = minRow + dr[d];
                int nextCol = minCol + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
                if (visited[nextRow][nextCol]) continue; // 이미 최소거리를 갱신한 곳이라면

                long value = grid[minRow][minCol] == grid[nextRow][nextCol] ? A : B;
                if (record[nextRow][nextCol] > minDist + value) {
                    record[nextRow][nextCol] = minDist + value;
//                    System.out.println(nextRow + " " + nextCol);
                    pq.add(new Element(nextRow, nextCol, minDist + value));
                    visited[nextRow][nextCol] = true;
                    max = Math.max(max, minDist + value);
                }
            }
        }

//        System.out.println("startRow & startCol : " + startRow + " & " + startCol + " max : " + max);
        answer = Math.max(answer, max);
    }

    static class Element {
        int row;
        int col;
        long dist;
        Element(int r, int c, long d) {
            row = r;
            col = c;
            dist = d;
        }
    }
}
