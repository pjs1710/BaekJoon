package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer S = new StringTokenizer(br.readLine(), " "); // 문자열을 공백을 기준으로 나눠서 토큰으로 저장

        // StringBuilder 가변 문자열을 처리하기 위한 클래스
        int A = Integer.parseInt(new StringBuilder(S.nextToken()).reverse().toString()); // StringBuilder로 토큰 입력받은걸 역순으로 변환한 후 String으로 저장 > 형변환으로 정수로 바꾸기
        int B = Integer.parseInt(new StringBuilder(S.nextToken()).reverse().toString());

        if (A > B) System.out.println(A); // 큰 수 출력하기
        else System.out.println(B);
    }
}
