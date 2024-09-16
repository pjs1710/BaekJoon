import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 최대로 일할 수 있는 일 수
        sc.nextLine();

        int[] T = new int[N]; // 상담 완료 기간
        int[] P = new int[N]; // 받는 금액
        int[] DP = new int[N + 1]; // 계산할 배열

        for (int i = 0; i < N; i++) { // 값들 넣기
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) { // 상담 가능한 경우
                DP[i + T[i]] = Math.max(DP[i + T[i]], DP[i] + P[i]);
            }
            // 상담 안되는 경우
            DP[i + 1] = Math.max(DP[i + 1], DP[i]);
        }
        System.out.println(DP[N]);
    }
}
