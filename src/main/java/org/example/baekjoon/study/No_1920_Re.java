package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_1920_Re {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder(); // 결과 저장
        int N = Integer.parseInt(br.readLine());
        int[] arr_N = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr_N[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_N);
        int M = Integer.parseInt(br.readLine());
        int[] arr_M = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr_M[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_M);
        /*
        (-1 2 4 5) N   (-1 2 4) N
        (-3 -1 2 6) M  (-3 -1 2 6 9) M
         */
        int target = 0;
        for (int i = 0; i < M; i++) {
            boolean found = false;
            while (target < N && arr_N[target] <= arr_M[i]) {
                if (arr_N[target] == arr_M[i]) { // 같은 값 찾음
                    found = true;
                    break;
                }
                target++; // arr_N[target]이 arr_M[i]보다 작으면 다음 요소로 이동
            }
            if (found) {
                sb.append("1\n"); // 존재하면 1 추가
            } else {
                sb.append("0\n"); // 존재하지 않으면 0 추가
            }
        }
    }
}
