package org.example.baekjoon.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2563 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[][] square = new boolean[100][100]; // 사각형의 왼쪽 하단 위치를 담을 2차원 배열
        int squ_sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x_point = Integer.parseInt(st.nextToken());
            int y_point = Integer.parseInt(st.nextToken());
            for (int j = x_point; j < x_point + 10; j++) {
                for (int k = y_point; k < y_point + 10; k++) {
                    if (!square[j][k]) {
                        square[j][k] = true;
                        squ_sum++;
                    }
                }
            }
        }
        System.out.println(squ_sum);
    }
}
