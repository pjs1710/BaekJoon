package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); int result = 1; // 입력받은 문자열을 S에 저장. 결과값을 1로 초기화해놓기
        char [] ch = new char[S.length()]; // 해당 문자열의 길이만큼 문자형 배열 할당
        for (int i = 0; i < S.length(); i++) {
            ch[i] = S.charAt(i); // 배열에 문자열을 char형으로 하나씩 넣기
        }
        for (int i = 0; i < 0.5*S.length(); i++) { // 배열의 중앙을 기준으로 반복문 실행
            if (ch[i] != ch[S.length() - 1 - i]) { // 팰린드롬 조건문 해당 index에 대응되는 반대 index와 값이 다르다면
                result = 0; // result = 0값으로 주기
                break; // 반복문 종료
            }
        }
        System.out.println(result);
    }
}
