import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 1000;

    static int N;
    static Segment[] segments = new Segment[MAX_N];

    // dp[i] : start 기준으로 정렬되어 있다는 가정에서
    // i 선분을 끝으로 겹치지 않게 선택할 수 있는 최대 선분의 수
    static int[] dp = new int[MAX_N];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        for (int i = 0; i < N; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            segments[i] = new Segment(start, end);
        }

        // start를 기준으로 오름차순 정렬 진행
        Arrays.sort(segments, 0, N, (a, b) -> a.start - b.start);

        for (int i = 0; i < N; i++) {
            // 현재 선분이 시작 선분인 경우
            // dp 값이 1이 되므로
            // 초기 세팅은 1이다.
            dp[i] = 1;

            // i 번째 선분 선택 전에
            // 바로 선택한 선분이 j라고 했을 때
            // i, j 선분이 서로 겹치지 않는 경우 중
            // 선택할 수 있는 선분의 최대 개수를 계산한다.
            for (int j = 0; j < i; j++) {
                int curStart = segments[i].start;
                int beforeEnd = segments[j].end;

                // 이미 start 순으로 정렬되어 있어
                // j의 end가 < i의 start 보다 작으면 겹치지 않는다
                if (beforeEnd < curStart) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 마지막으로 선택한 선분 위치가 i일 떄 경우 중
        // 고를 수 있는 선분의 수가 가장 큰 경우
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }


    // 선분을 저장할 클래스
    static class Segment {
        int start;
        int end;
        Segment(int s, int e) {
            start = s;
            end = e;
        }
    }
}
