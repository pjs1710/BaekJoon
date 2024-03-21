package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); int [] alp = new int[26]; // 문자열 입력받고 알파벳 수만큼 정수배열 할당해놓기
        for (int i = 0; i < 26; i++) {
            alp[i] = -1; // 정수배열에 -1 값 전부 저장
        }
        for (int i = 0; i < S.length(); i++) { // 입력받은 문자열의 문자 개수만큼 반복문 실행
            char ch = S.charAt(i); // 문자형 변수 ch에 입력받은 문자열을 문자 하나씩 저장
            int idx = ch - 'a'; // 해당 문자를 아스키코드 정수로 변환
            if (alp[idx] == -1) { // 정수배열에 알파벳이 해당하는 순서의 값이 -1이라면 (없다면)
                alp[idx] = i; // 배열에 해당 알파벳의 인덱스 값을 저장 ex) a : 0 , c : 2
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alp[i] + " ");
        }
    }
}
