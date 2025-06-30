package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No_3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] num = new int[n]; // 수를 담을 배열 == 수열
        int cnt = 0; // 순서쌍의 개수를 계산할 cnt 변수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine()); // 목표한 x값
        Arrays.sort(num); // 배열 정렬 후 투 포인터 시작
        int left = 0, right = n - 1;

        while (left < right) {
            int sum = num[left] + num[right];
            if (sum == x) { // 목표한 값이랑 두 수의 합이랑 동일
                right--;
                left++;
                cnt++;
            } else if (sum < x) { // 오름차순으로 정렬했기 때문에 왼쪽의 값을 ++해줘야함
                left++;
            } else {
                right--;
            }
        }
        System.out.println(cnt);
        //** 시간 초과 **//
        /*for (int i = 0; i < n; i++) {
            int a_i = num[i]; // ai를 배열에서 지정한 후
            for (int j = i + 1; j < n; j++) { // ai다음의 배열 aj를 다시 저장한 후
                int a_j = num[j];
                if (a_i + a_j == x) { // 두 수를 더했을 때 목표한 x가 나오면 순서쌍 하나를 찾은 것이므로 cnt++
                    cnt++;
                } // 조건문 만족 못하면 j++해줘야하니까 따로 else문 안해도 ㄱㅊ
            }
        }*/

    }
}
