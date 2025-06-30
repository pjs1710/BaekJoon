package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String [] a = new String[T]; // 입력받은 수만큼 문자형 배열 생성
        for (int i = 0; i < T; i++) {
            String S = br.readLine(); // 문자열 입력받기
            a[i] = String.valueOf(S.charAt(0)) + String.valueOf(S.charAt(S.length() - 1)); // a[] 문자형 배열 안에 charAt로 받은 문자 값을 String.valueOf로 형변환 해서 저장. (입력받은 문자의 첫번째 문자와 마지막 문자를 배열에 저장)
        }
        for (int i = 0; i < T; i++) {
            System.out.println(a[i]);
        }
    }
}