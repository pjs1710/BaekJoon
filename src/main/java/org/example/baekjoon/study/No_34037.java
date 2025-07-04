package org.example.baekjoon.study;

import java.io.*;
import java.util.*;

/**
 * 백준 34037 : 데이트 약속
 *
 */

public class No_34037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 데이트 기간 N일
        int M = Integer.parseInt(st.nextToken()); // 저주 수

        /**
         * 가상의 시작(0일)과 끝(N+1일)을 포함하여 배열 크기 설정
         *
         * description :
         * N일 동안 데이트를 하되, 저주일 M일에는 데이트를 쉬어야 함.
         * 따라서 연속된 데이트 구간은 저주일 사이 구간!
         *
         * ex. N = 10, 저주일 = 3, 5, 8
         * => 실제 데이트 가능한 구간은 1~2, 4, 6~7, 9~10
         * 그래서 배열을 선언할 때 첫 시작일과 마지막 일을 저주일로 가상으로 두고 시작하면 0, 3, 5, 8, 11 사이의 데이트 가능 구간이
         * 1~2, 4, 6~7, 9~10로 같게 나옵니다.
         */
        int[] X = new int[M + 2];
        long[] Y = new long[M + 2];

        // 0일 : 가상의 저주일
        X[0] = 0;
        Y[0] = 0;

        for (int i = 1; i <= M; i++) { // 1부터 입력 받아야 함
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Long.parseLong(st.nextToken());
        }

        // N + 1일 : 가상의 저주일
        X[M + 1] = N + 1;
        Y[M + 1] = 0;

        // int 자료형으로 하면 누적합 계산 때 overflow 발생할 수 있어서 long 타입으로 결정
        long[] SUM_Y = new long[M + 2];
        for (int i = 1; i <= M; i++) {
            SUM_Y[i] = SUM_Y[i - 1] + Y[i];
        }
        SUM_Y[M + 1] = SUM_Y[M];

        // dp[j] : j번째 저주 날에 쉴 때까지의 최대 애정 (long 타입)
        long[] dp = new long[M + 2];

        for (int j = 1; j < M + 2; j++) {
            long bestPrevVal = Long.MIN_VALUE;
            for (int k = 0; k < j; k++) {
               /**
                * 핵심 로직 :
                * k번째 저주 날 쉬고, j번째 저주 날 다시 쉼
                * 연속 데이트 기간: (X[k] + 1)일 ~ (X[j] - 1)일
                * length는 int 범위를 넘을 수 있으므로 long으로 계산
                */
                long length = (long) X[j] - X[k] - 1;
                long affectionGain = 0;
                if (length > 0) {
                    affectionGain = length * (length + 1) / 2; // 오버 플로우 발생 주의할 구간! int로 하면 발생할 수 있음
                }

                // 기간 내 패널티 합
                long penaltySum = SUM_Y[j - 1] - SUM_Y[k];

                // k시점까지의 최대 애정 + 이번 구간에서 얻은 순수 애정
                long curAffection = dp[k] + affectionGain - penaltySum;

                // 최대값 갱신
                if (curAffection > bestPrevVal) {
                    bestPrevVal = curAffection;
                }
            }
            dp[j] = bestPrevVal;
        }

        // dp[M + 1]이 N일까지 데이트를 마쳤을 때의 최대 애정
        System.out.println(dp[M + 1]);
    }
}
