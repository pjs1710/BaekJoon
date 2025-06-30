package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 입력할 횟수 정하기
        for (int i = 0; i < T; i++) {
            String[] S = br.readLine().split(" "); // 공백을 기준으로 배열 나누기 ex) 3 ABC > S[0] = 3, S[1] = ABC
            int R = Integer.parseInt(S[0]); // S 배열의 첫번째 값은 반복해서 출력할 횟수이므로 해당 값을 정수로 바꾸기
            String P = S[1]; // 반복할 문자열을 P로 지정
            for (int j = 0; j < P.length(); j++) { // P에 저장된 문자열의 개수만큼 반복문 시행 ex) ABC > 3번 반복 , ABCDE > 5번 반복
                for (int k = 0; k < R; k++) { // 지정한 반복 횟수만큼 문자열 반복해서 출력 ex) 3 AAABBBCCC
                    System.out.print(P.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
