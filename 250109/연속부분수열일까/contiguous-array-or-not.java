import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int a1 = sc.nextInt(); // arr1 크기
        int b1 = sc.nextInt(); // arr2 크기
        int arr1[] = new int[a1];
        int arr2[] = new int[b1];

        // arr1 입력
        for (int i = 0; i < a1; i++) {
            arr1[i] = sc.nextInt();
        }

        // arr2 입력
        for (int i = 0; i < b1; i++) {
            arr2[i] = sc.nextInt();
        }

        // 연속 부분 수열 여부 확인
        boolean found = false;

        // arr1에서 arr2[0]과 같은 모든 위치 검사
        for (int i = 0; i <= a1 - b1; i++) { // 시작 위치는 a1 - b1까지만 가능
            if (arr1[i] == arr2[0]) { // arr2[0]과 같은 시작점 발견
                boolean match = true;

                // arr2와 비교
                for (int j = 0; j < b1; j++) {
                    if (arr1[i + j] != arr2[j]) {
                        match = false;
                        break;
                    }
                }

                // 일치하는 경우
                if (match) {
                    found = true;
                    break;
                }
            }
        }

        // 결과 출력
        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
