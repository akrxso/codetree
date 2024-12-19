import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //참 거짓
        //a가 작으면 c보다도 작으면 a 아니면 c
        //a가 b보다도 크면 b<c 비교 b가 작으면 최솟값 b
        System.out.print(a<b ? (a<c ?a:c) : (b<c?b:c));
    }
}