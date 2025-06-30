package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); // 문자열 S 입력받기
        int i = Integer.parseInt(br.readLine()) - 1; // i번째 순서에 들어있는 문자 확인하려는 값 입력받기 / 배열은 0번부터 시작하니까 - 1 해주기

        System.out.println(S.charAt(i)); // charAt(n)함수 > 해당 데이터에서 특정 문자를 char 타입으로 변환하는 함수
    }
}
