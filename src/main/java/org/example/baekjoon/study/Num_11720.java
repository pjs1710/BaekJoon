package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력할 수의 개수 정하기
        int []a = new int[N]; int sum = 0; // 정수형 배열을 입력할 수 N개만큼 할당해놓기
        String S = br.readLine(); // 문자열로 수를 입력받기
        for (int i = 0; i < S.length(); i++) { // 문자열의 크기만큼 반복
            a[i] = S.charAt(i) - '0'; // 정수형 배열에 문자열로 입력받은 값에서 아스키코드 '0' 값을 빼서 정수로 변환하기
            sum += a[i]; // 정수로 변환한 값을 sum 값에 저장
        }
        System.out.println(sum);
    }
}
