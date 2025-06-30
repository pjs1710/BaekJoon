package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) { // 다이아몬드 중앙을 기준으로 위쪽에 공백과 별 찍기
            for (int j = 1; j <= N-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 1; i <= N-1; i++) { // 다이아몬드 중앙을 기준으로 아래쪽에 공백과 별 역순으로 찍기
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 2*i-1; j <= 2*N-3; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
