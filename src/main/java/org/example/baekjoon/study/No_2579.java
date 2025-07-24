package org.example.baekjoon.study;

/**
 * 백준 2579번 : 계단 오르기
 */

import java.io.*;
import java.util.*;

public class No_2579 {

    static int stepSize;
    static int[] result;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stepSize = Integer.parseInt(br.readLine()); // 계단 개수
        result = new int[stepSize];
        dp = new int[stepSize];

        for (int i = 0; i < stepSize; i++) {
            result[i] = Integer.parseInt(br.readLine());
        }

        if (stepSize == 1) {
            System.out.println(result[0]);
            return;
        } else if (stepSize == 2) {
            System.out.println(result[0] + result[1]);
            return;
        }

        dp[0] = result[0];
        dp[1] = result[0] + result[1];
        dp[2] = Math.max(result[0] + result[2], result[1] + result[2]); // 연속해서 갈 지, 한 단계 건너뛰고 갈 지 정하기
        // 2번째 이후부터 반복되는 작업 실행하면 됨
        for (int i = 3; i < stepSize; i++) {
            dp[i] = Math.max(dp[i - 3] + result[i - 1] + result[i], dp[i - 2] + result[i]);
        }

        System.out.println(dp[stepSize - 1]);
    }
}
