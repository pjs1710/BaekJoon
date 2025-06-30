package org.example.baekjoon.study;

import java.io.*;
import java.util.StringTokenizer;

public class Num_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] cnt = new int[10]; // 10개의 입력받을 수를 저장할 배열 생성.
        int num = 0; // 서로 다른 나머지를 카운트할 수.

        for (int i = 0; i < cnt.length; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            cnt[i] = N % 42; // 입력 받은 수를 42로 나눈 나머지의 값들을 순서대로 배열에 저장.

            boolean check = false; // 중복되는 값들이 있는지 체크
            for (int j = 0; j < i; j++) {
                if(cnt[i] == cnt[j]) { // 입력 받은 값을 이 전에 저장해둔 배열의 값들과 비교하며 같은 값이 있는지 확인
                    check = true; // 있다면 true
                    break; // 실행 중단
                }
                else check = false; // 입력 받은 값이 저장해둔 배열의 값들과 다름
            }
            if (!check) num++; // 다르기 때문에 num++
        }
        System.out.println(num);
    }
}
