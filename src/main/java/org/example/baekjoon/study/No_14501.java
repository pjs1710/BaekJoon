package org.example.baekjoon.study;

import java.util.Scanner;

public class No_14501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 최대로 일할 수 있는 일 수
        sc.nextLine();

        int[] T = new int[N]; // 상담 완료 기간
        int[] P = new int[N]; // 받는 금액
        int[] DP = new int[N + 1]; // 계산할 배열 DP[i] >> i일까지 번 최대 수익

        for (int i = 0; i < N; i++) { // 값들 넣기
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i + T[i] <= N) { // 상담 가능한 경우
                DP[i + T[i]] = Math.max(DP[i + T[i]], DP[i] + P[i]); // DP[상담일](상담일까지 최대 수익) = Max(기존 수익, 최대수익 + i일의 수익)
            }
            // 상담 안되는 경우
            DP[i + 1] = Math.max(DP[i + 1], DP[i]); // i일에 상담 안 했으니 i+1일의 최대 수익을 계산
        }
        System.out.println(DP[N]); // 최종적으로 퇴사일 까지의 최대 수익
    }
}
