package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer S = new StringTokenizer(br.readLine(), " "); // 문자열을 읽을 때 공백을 기준으로 토큰을 나눠서 S에 저장

        System.out.println(S.countTokens()); // S에 저장된 token 개수를 반환
    }
}
